package com.xiong.shop.security.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/4/5
 */
@Component
public class JsonLoginSecurityConfiguration extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private AuthenticationSuccessHandler commonAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler commonAuthenctiationFailureHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        JsonUsernamePasswordAuthenticationFilter authenticationFilter = new JsonUsernamePasswordAuthenticationFilter();
        authenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        authenticationFilter.setAuthenticationFailureHandler(commonAuthenctiationFailureHandler);
        authenticationFilter.setAuthenticationSuccessHandler(commonAuthenticationSuccessHandler);

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        http.authenticationProvider(daoAuthenticationProvider).addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
