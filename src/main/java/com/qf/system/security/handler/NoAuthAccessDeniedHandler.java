package com.qf.system.security.handler;

import com.alibaba.fastjson.JSON;
import com.qf.common.core.domain.BaseResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author : sin
 * @date : 2023/11/28 9:35
 * @Description : Security异常处理类
 */
@Slf4j
@Component
public class NoAuthAccessDeniedHandler implements AccessDeniedHandler {
    @SneakyThrows
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)  {
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(BaseResponse.fail(500, accessDeniedException.getMessage())));
    }
}