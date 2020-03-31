package com.xiong.shop.enums;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/3/31
 */
public enum ResponseResultEnum {
    // 统一成功
    SUCCESS(200, "成功"),
    // 通用失败
    FAILED(400, "失败"),
    USER_NOT_EXISTS(600, "用户不存在"),
    USER_OR_PASSWORD_NOT_CORRECT(601, "用户或密码不正确"),
    ;

    private Integer code;

    private String message;

    ResponseResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
