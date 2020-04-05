package com.xiong.shop.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiong.shop.result.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功后返回json
 *
 * @Author: XiongGaoXiang
 * @Date: 2020/4/5
 */
@Component("commonAuthenctiationFailureHandler")
public class CommonAuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.error("认证失败");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(ResponseResult.fail()));
    }
}
