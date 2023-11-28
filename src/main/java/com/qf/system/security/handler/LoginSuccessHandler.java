package com.qf.system.security.handler;

import com.alibaba.fastjson.JSON;
import com.qf.common.core.domain.BaseResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

/**
 * @author : sin
 * @date : 2023/11/28 9:19
 * @Description : 登录成功响应
 */
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("登录成功!");
        // 响应数据
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(BaseResponse.success(null)));
    }
}