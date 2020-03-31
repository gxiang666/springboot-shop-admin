package com.xiong.shop.result;

import com.xiong.shop.enums.ResponseResultEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/3/31
 */
@Data
@ApiModel(value = "ResponseResult", description = "返回结果")
public class ResponseResult implements Serializable {

    @ApiModelProperty(value = "返回数据")
    private Object data;
    @ApiModelProperty(value = "返回值编码")
    private Integer code;
    @ApiModelProperty(value = "返回值信息")
    private String message;

    private ResponseResult() {
    }

    private ResponseResult(ResponseResultEnum resEnum) {
        this.code = resEnum.getCode();
        this.message = resEnum.getMessage();
        this.data = null;
    }

    private ResponseResult(String message, Integer code) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    private ResponseResult(ResponseResultEnum resEnum, Object data) {
        this.code = resEnum.getCode();
        this.message = resEnum.getMessage();
        this.data = data;
    }


    public static ResponseResult success() {
        return new ResponseResult(ResponseResultEnum.SUCCESS);
    }

    public static ResponseResult success(Object data) {
        return new ResponseResult(ResponseResultEnum.SUCCESS, data);
    }


    public static ResponseResult fail() {
        return new ResponseResult(ResponseResultEnum.FAILED);
    }

    public static ResponseResult fail(Object data) {
        return new ResponseResult(ResponseResultEnum.FAILED, data);
    }

    public static ResponseResult fail(ResponseResultEnum resEnum) {
        return new ResponseResult(resEnum);
    }

    public static ResponseResult fail(ResponseResultEnum resEnum, Object data) {
        return new ResponseResult(resEnum, data);
    }

    public static ResponseResult fail(String message, Integer code) {
        return new ResponseResult(message, code);
    }

}
