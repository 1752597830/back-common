package com.qf.system.security.auth;

import com.qf.common.constant.Constant;
import com.qf.common.utils.GeneralUtil;
import com.qf.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * @author : sin
 * @date : 2023/11/28 20:27
 * @Description : 通过拦截器方式动态实现权限校验
 */
@Slf4j
@Component
public class MyauthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {
    @Override
    public void verify(Supplier<Authentication> authentication, RequestAuthorizationContext object) {
        AuthorizationManager.super.verify(authentication, object);
    }

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext requestAuthorizationContext) {
        if (!(authentication.get().getPrincipal() instanceof User)) {
            throw new AccessDeniedException("匿名不可访问!");
        }
        User user = (User) authentication.get().getPrincipal();

        //访问的接口地址
        String requestURI = requestAuthorizationContext.getRequest().getRequestURI();
        //匿名地址直接访问
        if (GeneralUtil.contains(requestURI, Constant.annos)) {
            return new AuthorizationDecision(true);
        }
        //查询当前请求的接口需要哪些权限能访问


        // 权限校验
        log.info("权限处理!");
        return new AuthorizationDecision(true);
        //throw new AccessDeniedException(user.getUsername()+",没有访问:"+requestURI+"的权限");
    }
}