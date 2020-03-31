package com.xiong.shop.controller;


import com.xiong.shop.result.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author xionggaoxiang
 * @since 2020-03-31
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @GetMapping("/list")
    public ResponseResult selectUserList() {
        return ResponseResult.success();
    }

}
