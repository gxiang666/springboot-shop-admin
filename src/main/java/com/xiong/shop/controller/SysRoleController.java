package com.xiong.shop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiong.shop.dto.CommonDeleteOrDetailDTO;
import com.xiong.shop.dto.SelectRoleDTO;
import com.xiong.shop.dto.RoleCreatelDTO;
import com.xiong.shop.dto.RoleUpdateDTO;
import com.xiong.shop.entity.SysRole;
import com.xiong.shop.result.ResponseResult;
import com.xiong.shop.service.SysRoleService;
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
 * 角色表 前端控制器
 * </p>
 *
 * @author xionggaoxiang
 * @since 2020-03-31
 */
@RestController
@RequestMapping("/sysRole")
@Api(tags = "角色管理")
public class SysRoleController {

    @Autowired
    private SysRoleService roleService;

    @PostMapping(value = "/create")
    @ApiOperation(value = "创建角色")
    public ResponseResult create(@RequestBody @Valid RoleCreatelDTO menuCreatelDTO) {
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(menuCreatelDTO, sysRole);
        return ResponseResult.success(roleService.save(sysRole));
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除角色")
    public ResponseResult delete(@RequestBody @Valid CommonDeleteOrDetailDTO commonDTO) {
        SysRole sysRole = new SysRole();
        sysRole.setId(commonDTO.getId());
        sysRole.setDelFlag(true);
        return ResponseResult.success(roleService.updateById(sysRole));
    }

    @PostMapping(value = "/selectList")
    @ApiOperation(value = "查询角色列表")
    public ResponseResult selectList(@RequestBody @Valid SelectRoleDTO selectRoleDTO) {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(selectRoleDTO.getEname())) {
            queryWrapper.like("ename", selectRoleDTO.getEname());
        }
        queryWrapper.eq("del_flag", 0);
        List<SysRole> list = roleService.list(queryWrapper);
        return ResponseResult.success(list);
    }

    @PostMapping(value = "/selectPage")
    @ApiOperation(value = "查询角色分页")
    public ResponseResult selectPage(@RequestBody @Valid SelectRoleDTO selectRoleDTO) {
        Page<SysRole> page = new Page<>();
        page.setSize(selectRoleDTO.getSize());
        page.setCurrent(selectRoleDTO.getCurrent());
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(selectRoleDTO.getEname())) {
            queryWrapper.like("ename", selectRoleDTO.getEname());
        }
        queryWrapper.eq("del_flag", 0);
        IPage<SysRole> list = roleService.page(page, queryWrapper);
        return ResponseResult.success(list);
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "更新角色")
    public ResponseResult update(@RequestBody @Valid RoleUpdateDTO menuUpdateDTO) {
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(menuUpdateDTO, sysRole);
        return ResponseResult.success(roleService.updateById(sysRole));
    }

    @PostMapping(value = "/detail")
    @ApiOperation(value = "查询角色详情")
    public ResponseResult detail(@RequestBody @Valid CommonDeleteOrDetailDTO commonDTO) {
        return ResponseResult.success(roleService.getById(commonDTO.getId()));
    }

}
