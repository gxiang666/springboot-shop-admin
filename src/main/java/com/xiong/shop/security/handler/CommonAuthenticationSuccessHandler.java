package com.xiong.shop.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiong.shop.result.ResponseResult;
import com.xiong.shop.security.jwt.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败后返回json
 *
 * @Author: XiongGaoXiang
 * @Date: 2020/4/5
 */
@Slf4j
@Component("commonAuthenticationSuccessHandler")
public class CommonAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info(authentication.getName() + "登录成功");
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Authorization", jwtUtil.generaterToken(authentication.getName()));
        response.getWriter().write(objectMapper.writeValueAsString(ResponseResult.success()));
    }
}
