package com.xiong.shop.enums;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/3/31
 */
public enum ResponseResultEnum {
    // 成功
    SUCCESS(200, "成功"),
    // 失败
    FAILED(400, "失败"),
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
