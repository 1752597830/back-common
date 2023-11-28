package com.qf.system.security.handler;

import com.alibaba.fastjson.JSON;
import com.qf.common.core.domain.BaseResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        String  result;
        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException || e instanceof AuthenticationServiceException) {
            result = e.getMessage();
        } else if (e instanceof LockedException) {
            result = "账户被锁定，请联系管理员!";
        } else if (e instanceof CredentialsExpiredException) {
            result = "证书过期，请联系管理员!";
        } else if (e instanceof AccountExpiredException) {
            result = "账户过期，请联系管理员!";
        } else if (e instanceof DisabledException) {
            result = "账户被禁用，请联系管理员!";
        } else {
            //log.error("登录失败：", e);
            result = "登录失败!";
        }
        log.info("登录失败!");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(BaseResponse.fail(500, result)));
    }
}