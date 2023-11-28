package com.qf.common.filter;

import com.alibaba.fastjson.JSON;
import com.qf.common.constant.Constant;
import com.qf.common.core.domain.BaseResponse;
import com.qf.common.utils.BeanUtils;
import com.qf.common.utils.GeneralUtil;
import com.qf.common.utils.JwtUtil;
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


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1、判断url是否匿名访问
        String requestURI = request.getRequestURI();
        //匿名地址直接访问
        if(GeneralUtil.contains(requestURI, Constant.annos)){
            filterChain.doFilter(request, response);
            return;
        }
        // 2、获取JWT
        String token = request.getHeader("Authorization");
        //log.info("接收到的token:{}",token);
        if( token == null ) {
            response.setStatus(200);
            response.setContentType("application/json;charset=UTF-8");
            log.info("未登录无法访问!");
            response.getWriter().write(JSON.toJSONString(BaseResponse.fail(401, "未登录无法访问！")));
            return;
        }
        if (token != null) {
            try {
                JwtUtil jwtUtil = BeanUtils.getBean("JWTToken");
                jwtUtil.tokenVerify(token);
            }catch (Exception e){
                throw e;
                //response.setStatus(200);
                //response.setContentType("application/json;charset=UTF-8");
                //log.info("非法token");
                //response.getWriter().write(JSON.toJSONString(BaseResponse.fail(400, "非法token")));
                //return;
            }
        }
        log.info("校验成功");
        filterChain.doFilter(request,response);
    }
}