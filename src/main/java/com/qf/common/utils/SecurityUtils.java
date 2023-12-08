package com.qf.common.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

/**
 * @author : sin
 * @date : 2023/12/6 23:41
 * @Description : Security 工具类
 */
public class SecurityUtils {
    /**
     * 通过SecurityContextHandler获取当前用户身份令牌
     */
    public static Authentication getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }
    /**
     * 通过Authentication获取当前用户信息
     */
    //public static SysUser getUserInfo() {
    //    Authentication authentication = getAuthentication();
    //    if (authentication != null) {
    //        Object principal = authentication.getPrincipal();
    //        if (principal instanceof SysUser) {
    //            SysUser user = (SysUser) authentication.getPrincipal();
    //            return user;
    //        }
    //    }
    //    throw new BaseException(ResultCode.NOT_LOGIN_ERROR.getCode(), ResultCode.NOT_LOGIN_ERROR.getMessage());
    //}
}