package com.qf.common.core.exception;

/**
 * @author : sin
 * @date : 2023/11/26 13:22
 * @Description : 自定义异常类
 */
public class BaseException extends RuntimeException {

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误信息
     */
    private String errMessage;

    public BaseException() {

    }

    public BaseException(String code, String errMessage) {
        this.code = code;
        this.errMessage = errMessage;
    }

    public String getCode() {
        return code;
    }

    public String getErrMessage() {
        return errMessage;
    }
}