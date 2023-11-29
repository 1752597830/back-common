package com.qf.common.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qf.common.constant.UserConstant;
import com.qf.common.core.domain.ResultCode;
import com.qf.common.utils.BodyReaderRequestWrapper;
import com.qf.common.utils.RedisCache;
import com.qf.common.utils.ServletUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author : sin
 * @date : 2023/11/29 17:45
 * @Description :
 */
@Component
@Slf4j
public class VerifyCodeFilter extends GenericFilterBean {
    private String defaultFilterProcessUrl = "/login";

    @Autowired
    private RedisCache redisCache;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        if ("POST".equalsIgnoreCase(request.getMethod()) && defaultFilterProcessUrl.equals(request.getServletPath())) {
            ServletRequest requestWrapper = null;
            ObjectMapper mapper = new ObjectMapper();

            if (request instanceof HttpServletRequest) {
                requestWrapper = new BodyReaderRequestWrapper(request);
            }
            if (requestWrapper != null) {
                try (InputStream is = requestWrapper.getInputStream()) {
                    Map<String, String> map = mapper.readValue(is, Map.class);
                    String code = map.get("code");
                    String uuid = map.get("uuid");
                    if (StringUtils.isEmpty(code)) {
                        //throw new BaseException("验证码不能为空!");
                        ServletUtils.renderString(response, ResultCode.VERIFY_CODE_NOTNULL.getCode(), ResultCode.VERIFY_CODE_NOTNULL.getMessage());
                        return;
                    }
                    if (!code.equals(redisCache.getCacheObject(UserConstant.captcha + uuid))) {
                        //throw new BaseException("验证码错误!");
                        ServletUtils.renderString(response, ResultCode.VERIFY_CODE_ERROR.getCode(), ResultCode.VERIFY_CODE_ERROR.getMessage());
                        return;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    ServletUtils.renderString(response, ResultCode.SYSTEM_ERROR.getCode(), ResultCode.SYSTEM_ERROR.getMessage());
                    return;
                }
                chain.doFilter(requestWrapper, response);
            }
        }
        chain.doFilter(request, response);
    }
}