package com.qf.common.core.domain;

/**
 * @author : sin
 * @date : 2023/11/26 12:46
 * @Description : 接口统一响应对象返回
 */
public enum ResultCode {

    /* 操作成功 */
    SUCCESS(200, "ok"),

    /* 操作失败 */
    ERROR(500, "操作失败");
    /* 自定义状态码 */
    private int code;

    /* 自定义返回信息 */
    private String message;
    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
