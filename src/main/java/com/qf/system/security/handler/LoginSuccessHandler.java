package com.qf.system.security.handler;

import com.alibaba.fastjson.JSON;
import com.qf.common.core.domain.BaseResponse;
import com.qf.common.utils.BeanUtils;
import com.qf.common.utils.JwtUtil;
import com.qf.domain.User;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : sin
 * @date : 2023/11/28 9:19
 * @Description : 登录成功响应
 */
@Slf4j
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    JwtUtil jwtUtil;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
        log.info("登录成功!");
        //JwtUtil jwtUtil = BeanUtils.getBean("JWTToken");

        String token = jwtUtil.token(auth);
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(BaseResponse.success(map)));
    }
}