package com.qf.system.security.handler;

import com.alibaba.fastjson.JSON;
import com.qf.common.core.domain.BaseResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

/**
 * @author : sin
 * @date : 2023/11/28 9:20
 * @Description : 登录失败响应
 */
@Slf4j
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("登录失败!");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(BaseResponse.fail(500, exception.getMessage())));
    }
}