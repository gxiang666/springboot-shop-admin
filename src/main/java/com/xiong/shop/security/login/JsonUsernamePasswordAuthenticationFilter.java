package com.xiong.shop.security.login;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 拦截json请求的拦截器
 * 路径： /login  请求方式： POST
 *
 * @Author: XiongGaoXiang
 * @Date: 2020/4/5
 */
public class JsonUsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public JsonUsernamePasswordAuthenticationFilter() {
        super(new AntPathRequestMatcher("/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        // 获取json请求体
        String body = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));

        // 获取用户和密码
        String username = null;
        String password = null;
        if (StringUtils.hasText(body)) {
            JSONObject jsonObject = JSON.parseObject(body);
            username = jsonObject.getString("username");
            password = jsonObject.getString("password");
        }

        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        // 设置一些信息
        setDetails(request, token);
        return this.getAuthenticationManager().authenticate(token);
    }

    protected void setDetails(HttpServletRequest request,
                              UsernamePasswordAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }
}
