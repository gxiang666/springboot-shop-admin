package com.xiong.shop.security;

import com.xiong.shop.security.jwt.JwtSecurityConfiguration;
import com.xiong.shop.security.login.JsonLoginSecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/4/5
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JsonLoginSecurityConfiguration jsonLoginSecurityConfiguration;

    @Autowired
    private JwtSecurityConfiguration jwtSecurityConfiguration;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin().disable()
                .sessionManagement().disable()
                .cors()
//                .and()
//                .headers().addHeaderWriter(new StaticHeadersWriter(Arrays.asList(
//                new Header("Access-control-Allow-Origin", "*"),
//                new Header("Access-Control-Expose-Headers", "Authorization"))))
                .and()
                .apply(jsonLoginSecurityConfiguration)
                .and()
                .apply(jwtSecurityConfiguration);
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return userDetailsService;
    }

}
