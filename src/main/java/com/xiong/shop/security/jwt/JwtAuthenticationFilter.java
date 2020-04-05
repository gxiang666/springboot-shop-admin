package com.xiong.shop.security.jwt;

import com.auth0.jwt.JWT;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拦截请求头中携带Authorization的请求
 *
 * @Author: XiongGaoXiang
 * @Date: 2020/4/5
 */
public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    /**
     * 拦截请求头中携带Authorization的请求
     */
    public JwtAuthenticationFilter() {
        super(new RequestHeaderRequestMatcher("Authorization"));
    }

    /**
     * 获取token封装到JwtAuthenticatiionToken中，交给AuthenticationManager进行验证
     *
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String token = getToken(request);
        if (token == null) {
            token = "";
        }
        JwtAuthenticatiionToken jwtAuthenticatiionToken = new JwtAuthenticatiionToken(JWT.decode(token));
        setDetails(request, jwtAuthenticatiionToken);
        return this.getAuthenticationManager().authenticate(jwtAuthenticatiionToken);
    }

    /**
     * 从请求对象中获取token
     *
     * @param request
     * @return
     */
    private String getToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        return StringUtils.removeStart(authorization, "Bearer ");
    }

    /**
     * 设置详细信息
     *
     * @param request
     * @param authRequest
     */
    protected void setDetails(HttpServletRequest request,
                              JwtAuthenticatiionToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

    /**
     * 验证通过放行，请求资源
     *
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(authResult);
        chain.doFilter(request, response);
    }
}
