package com.qf.common.filter;

import com.qf.common.constant.Constant;
import com.qf.common.core.domain.ResultCode;
import com.qf.common.utils.GeneralUtil;
import com.qf.common.utils.JwtUtil;
import com.qf.common.utils.ServletUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author : sin
 * @date : 2023/11/27 22:53
 * @Description : JWT Token 拦截器
 */
@Component
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Value("${token.header}")
    private String header;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1、判断url是否匿名访问
        String requestURI = request.getRequestURI();
        log.info("url请求是：" + requestURI);
        //匿名地址直接访问
        if(GeneralUtil.contains(requestURI, Constant.annos)){
            filterChain.doFilter(request, response);
            return;
        }
        // 2、获取JWT
        String token = request.getHeader(header);
        //log.info("接收到的token:{}",token);
        if( token == null ) {
            ServletUtils.renderString(response, ResultCode.NOT_LOGIN_ERROR.getCode(), ResultCode.NOT_LOGIN_ERROR.getMessage());
            return;
        }
        if (token != null) {
            try {
                jwtUtil.tokenVerify(token);
            }catch (Exception e){
                ServletUtils.renderString(response, ResultCode.LOGIN_EXPIRED.getCode(), ResultCode.LOGIN_EXPIRED.getMessage());
                return;
            }
        }
        log.info("校验成功");
        filterChain.doFilter(request,response);
    }
}