package com.xiong.shop.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.stereotype.Component;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/4/5
 */
@Component
public class JwtSecurityConfiguration extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private AuthenticationFailureHandler commonAuthenctiationFailureHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    @Value("${jwt.tokenKey}")
    private String tokenKey;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter();
        jwtAuthenticationFilter.setAuthenticationFailureHandler(commonAuthenctiationFailureHandler);
        jwtAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));

        JwtAuthenticationProvider jwtAuthenticationProvider = new JwtAuthenticationProvider(userDetailsService, tokenKey);
        http.authenticationProvider(jwtAuthenticationProvider).addFilterBefore(jwtAuthenticationFilter, LogoutFilter.class);
    }
}
