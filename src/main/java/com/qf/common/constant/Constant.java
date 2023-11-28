package com.qf.common.constant;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @author : sin
 * @date : 2023/11/27 22:57
 * @Description : 常量池
 */
@Data
@Configuration
public class Constant {
    public static String[] annos = {
            "/register",
            "/login",
            "/unAuth",
            "/user/refreshToken",
            "/test1",
            ".css",
            "**.css",
            ".js",
            "**.js",
            "/doc.html",
            "/swagger-ui",
            "/swagger-ui/**",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/favicon.ico",
    };

    public static List<String> annosList = Arrays.asList(annos);
}