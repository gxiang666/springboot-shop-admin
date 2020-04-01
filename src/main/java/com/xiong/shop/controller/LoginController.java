package com.xiong.shop.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiong.shop.dto.LoginDTO;
import com.xiong.shop.entity.SysUser;
import com.xiong.shop.enums.ResponseResultEnum;
import com.xiong.shop.result.ResponseResult;
import com.xiong.shop.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/3/31
 */
@RestController
@Api(tags = "登录管理")
public class LoginController {

    @Autowired
    private SysUserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "用户登录接口")
    public ResponseResult login(@RequestBody @Valid LoginDTO loginDTO) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", loginDTO.getUsername()).eq("del_flag", 0);
        SysUser user = userService.getOne(queryWrapper);
        if (Objects.isNull(user)) {
            return ResponseResult.fail(ResponseResultEnum.USER_NOT_EXISTS);
        }
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            return ResponseResult.fail(ResponseResultEnum.USER_OR_PASSWORD_NOT_CORRECT);
        }
        return ResponseResult.success(user.getUsername());
    }

}
