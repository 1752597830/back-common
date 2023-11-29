package com.qf.common.config;

import com.qf.common.constant.Constant;
import com.qf.common.filter.JwtAuthenticationTokenFilter;
import com.qf.common.filter.VerifyCodeFilter;
import com.qf.system.security.auth.MyauthorizationManager;
import com.qf.system.security.exception.NoAuthenticationEntryPoint;
import com.qf.system.security.filter.LoginAuthenticationFilter;
import com.qf.system.security.handler.LoginFailureHandler;
import com.qf.system.security.handler.LoginSuccessHandler;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author : sin
 * @date : 2023/11/28 8:48
 * @Description : Security 配置类
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class SecurityConfig {

    @Resource
    private AuthenticationConfiguration authenticationConfiguration;

    /**
     * 自定义权限校验
     */
    @Resource
    private MyauthorizationManager authorizationManager;

    /**
     * 自定义认证
     */
    @Resource
    private NoAuthenticationEntryPoint noAuthenticationEntryPoint;

    /**
     * token拦截器
     */
    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    /**
     * 验证码拦截器
     */
    @Resource
    private VerifyCodeFilter verifyCodeFilter;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(e -> e.requestMatchers(Constant.annos).permitAll());
        http.authorizeHttpRequests(e->e.anyRequest().access(authorizationManager));

        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(verifyCodeFilter, UsernamePasswordAuthenticationFilter.class);
        // 重新登录
        http.addFilterAt(loginAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.formLogin(e -> e.successHandler(new LoginSuccessHandler()).failureHandler(new LoginFailureHandler()));
        // 异常处理
        // 登录授权 401
        http.exceptionHandling(e -> e.authenticationEntryPoint(noAuthenticationEntryPoint));


        // 跨域漏洞防御 关闭
        http.csrf(e -> e.disable());
        // 跨域拦截 关闭
        http.cors(e -> e.disable());
        return http.build();
    }

    /**
     * 强散列哈希加密实现
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public LoginAuthenticationFilter loginAuthenticationFilter() throws Exception {
        LoginAuthenticationFilter filter = new LoginAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(new LoginSuccessHandler());
        filter.setAuthenticationFailureHandler(new LoginFailureHandler());
        //LoginAuthenticationFilter 中需要使用到AuthenticationManager 不加会出现空指针
        filter.setAuthenticationManager(authenticationConfiguration.getAuthenticationManager());
        return filter;
    }

}