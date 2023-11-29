package com.qf.system.service.impl;

import com.qf.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : sin
 * @date : 2023/11/28 8:54
 * @Description :
 */
@Service
public class LoginUserServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        //测试密码 123456
        User user = new User(username, "$2a$10$Un8DAyq6H3gXDeVCzAznH.6LG8QBqukMjViOB3lYaA9hsu4TTBP3G");
        user.setAuthorities(null);
        return user;
    }
}