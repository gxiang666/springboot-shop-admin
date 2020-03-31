package com.xiong.shop.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/3/31
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    /**
     * 跨域处理
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 域名
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                // 超时时间
                .maxAge(3600)
                // 是否支持cookie跨域
                .allowCredentials(true);
    }
}
