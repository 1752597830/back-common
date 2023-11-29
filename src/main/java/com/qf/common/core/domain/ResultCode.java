package com.qf.common.core.domain;

/**
 * @author : sin
 * @date : 2023/11/26 12:46
 * @Description : 接口统一响应对象返回
 */
public enum ResultCode {

    /* 操作成功 */
    SUCCESS("200", "ok"),

    /* 操作失败 */
    ERROR("500", "操作失败"),

    PARAMS_ERROR("40000", "请求参数错误"),
    VERIFY_CODE_ERROR("40001", "验证码错误"),
    VERIFY_CODE_NOTNULL("40002", "验证码不能为空"),
    NOT_LOGIN_ERROR("40100", "未登录"),
    LOGIN_EXPIRED("40100", "登录过期，请重新登录"),
    NO_AUTH_ERROR("40101", "无权限"),
    NOT_FOUND_ERROR("40400", "请求数据不存在"),
    FORBIDDEN_ERROR("40300", "禁止访问"),
    SYSTEM_ERROR("50000", "系统内部异常"),
    OPERATION_ERROR("50001", "操作失败");
    /* 自定义状态码 */
    private String code;

    /* 自定义返回信息 */
    private String message;
    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
