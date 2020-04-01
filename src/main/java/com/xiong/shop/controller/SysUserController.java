package com.xiong.shop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiong.shop.dto.CommonDeleteOrDetailDTO;
import com.xiong.shop.dto.SelectUserDTO;
import com.xiong.shop.dto.UserCreatelDTO;
import com.xiong.shop.dto.UserUpdateDTO;
import com.xiong.shop.entity.SysUser;
import com.xiong.shop.result.ResponseResult;
import com.xiong.shop.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

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
@Api(tags = "用户管理")
public class SysUserController {

    @Autowired
    private SysUserService userService;

    @PostMapping(value = "/create")
    @ApiOperation(value = "创建用户")
    public ResponseResult create(@RequestBody @Valid UserCreatelDTO menuCreatelDTO) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(menuCreatelDTO, sysUser);
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        sysUser.setPassword(passwordEncoder.encode(menuCreatelDTO.getPassword()));
        return ResponseResult.success(userService.save(sysUser));
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除用户")
    public ResponseResult delete(@RequestBody @Valid CommonDeleteOrDetailDTO commonDTO) {
        SysUser sysUser = new SysUser();
        sysUser.setId(commonDTO.getId().longValue());
        sysUser.setDelFlag(true);
        return ResponseResult.success(userService.updateById(sysUser));
    }

    @PostMapping(value = "/selectList")
    @ApiOperation(value = "查询用户列表")
    public ResponseResult selectList(@RequestBody @Valid SelectUserDTO selectUserDTO) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(selectUserDTO.getUsername())) {
            queryWrapper.like("username", selectUserDTO.getUsername());
        }
        queryWrapper.eq("del_flag", 0);
        List<SysUser> list = userService.list(queryWrapper);
        return ResponseResult.success(list);
    }

    @PostMapping(value = "/selectPage")
    @ApiOperation(value = "查询用户分页")
    public ResponseResult selectPage(@RequestBody @Valid SelectUserDTO selectUserDTO) {
        Page<SysUser> page = new Page<>();
        page.setSize(selectUserDTO.getSize());
        page.setCurrent(selectUserDTO.getCurrent());
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(selectUserDTO.getUsername())) {
            queryWrapper.like("username", selectUserDTO.getUsername());
        }
        queryWrapper.eq("del_flag", 0);
        IPage<SysUser> list = userService.page(page, queryWrapper);
        return ResponseResult.success(list);
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "更新用户")
    public ResponseResult update(@RequestBody @Valid UserUpdateDTO menuUpdateDTO) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(menuUpdateDTO, sysUser);
        return ResponseResult.success(userService.updateById(sysUser));
    }

    @PostMapping(value = "/detail")
    @ApiOperation(value = "查询用户详情")
    public ResponseResult detail(@RequestBody @Valid CommonDeleteOrDetailDTO commonDTO) {
        return ResponseResult.success(userService.getById(commonDTO.getId()));
    }
}
