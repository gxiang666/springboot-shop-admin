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
                // 允许所有域名请求
                .allowedOrigins("*")
                // 允许携带所有请求头
                .allowedHeaders("*")
                // 暴露响应头给前端
                .exposedHeaders("Authorization")
                // 允许所有方法请求
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                // 超时时间
                .maxAge(3600)
                // 是否支持cookie跨域
                .allowCredentials(true);
    }
}
