package com.qf.common.core.controller;

import com.qf.common.core.domain.BaseResponse;
import com.qf.common.core.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : sin
 * @date : 2023/11/26 13:29
 * @Description :
 */
@RestController
@Slf4j
public class TestController {

    @RequestMapping("/test")
    public BaseResponse test() {
        throw new BaseException("501", "用户不存在");
    }

    @RequestMapping("/test1")
    public BaseResponse test1() {
        log.info("进来了");
        throw new BaseException("100", "校验了");
    }
}