package com.qf.common.filter;

import com.alibaba.fastjson.JSON;
import com.qf.common.core.domain.BaseResponse;
import com.qf.common.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
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
    private static String HEADER;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1、判断url是否匿名访问
        String requestURI = request.getRequestURI();
        //匿名地址直接访问
        //if(qfTools.contains(requestURI, Constant.annos)){
        //    filterChain.doFilter(request, response);
        //    return;
        //}
        // 2、获取JWT
        String token = request.getHeader(HEADER);
        log.info("接收到的token:{}",token);
        if( token == null ) {
            response.setStatus(200);
            response.setContentType("application/json;charset=UTF-8");
            log.info("未登录无法访问!");
            response.getWriter().write(JSON.toJSONString(BaseResponse.fail(400, "未登录无法访问！")));
            return;
        }
        if (token != null) {
            try {
                JwtUtil.tokenVerify(token);
            }catch (Exception e){
                response.setStatus(200);
                response.setContentType("application/json;charset=UTF-8");
                log.info("非法token");
                response.getWriter().write(JSON.toJSONString(BaseResponse.fail(400, "非法token")));
                return;
            }
        }
        filterChain.doFilter(request,response);
    }
}