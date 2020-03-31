package com.xiong.shop.handler;

import com.xiong.shop.result.ResponseResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/3/31
 */
@RestControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseResult handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ResponseResult.fail(ex.getBindingResult().getFieldError().getDefaultMessage(), 400);
    }
}
