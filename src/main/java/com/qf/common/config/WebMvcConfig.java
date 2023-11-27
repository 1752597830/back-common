package com.qf.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : sin
 * @date : 2023/11/27 23:03
 * @Description : 配置跨域
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //.allowedOrigins("*")
                .allowCredentials(false)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .allowedOriginPatterns("*")
                // 设置允许的header属性
                .allowedHeaders("*")
                .maxAge(3600);
    }
}