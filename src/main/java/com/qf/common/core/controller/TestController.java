package com.qf.common.core.controller;

import com.qf.common.core.domain.BaseResponse;
import com.qf.common.core.exception.BaseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : sin
 * @date : 2023/11/26 13:29
 * @Description :
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public BaseResponse test() {
        throw new BaseException(501, "用户不存在");
    }
}