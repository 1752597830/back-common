package com.qf.common.core.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : sin
 * @date : 2023/11/26 13:03
 * @Description : 响应结果封装对象
 */
@Data
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 1901152752394073986L;

    /**
     * 响应状态码
     */
    private String code;

    /**
     * 响应结果描述
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 成功返回
     */
    public static <T> BaseResponse<T> success(T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(ResultCode.SUCCESS.getCode());
        response.setMessage(ResultCode.SUCCESS.getMessage());
        response.setData(data);
        return response;
    }

    /**
     * 失败返回
     */
    public static <T> BaseResponse<T> fail(String message){

        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(ResultCode.ERROR.getCode());
        response.setMessage(message);

        return response;
    }
    /**
     * 失败返回
     */
    public static <T> BaseResponse<T> fail(String code, String message){

        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(code);
        response.setMessage(message);

        return response;
    }
}