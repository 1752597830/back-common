package com.qf.common.core.controller;

import com.qf.common.constant.UserConstant;
import com.qf.common.core.domain.BaseResponse;
import com.qf.common.utils.RedisCache;
import com.wf.captcha.ArithmeticCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author : sin
 * @date : 2023/12/6 21:03
 * @Description :
 */
@RestController
public class CaptchaController {

    @Autowired
    private RedisCache redisCache;


    //http://vapi.youlai.tech/api/v1/auth/captcha
    @GetMapping("/captcha")
    public BaseResponse getCaptcha() {
        UUID uuid = UUID.randomUUID();
        // 算术类型
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(130, 48);
        captcha.setLen(3);  // 几位数运算，默认是两位
        String result = captcha.text();  // 获取运算的结果：5
        // 存储到redis
        redisCache.setCacheObject(UserConstant.captcha + uuid, result);

        String base64 = captcha.toBase64();
        Map<String , String> map = new HashMap<>();
        map.put("captchaBase64", base64);
        map.put("captchaKey", String.valueOf(uuid));
        return BaseResponse.success(map);
    }
}