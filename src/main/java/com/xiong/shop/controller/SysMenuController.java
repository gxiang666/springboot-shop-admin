package com.xiong.shop.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiong.shop.dto.CommonDeleteOrDetailDTO;
import com.xiong.shop.dto.MenuCreatelDTO;
import com.xiong.shop.dto.MenuUpdateDTO;
import com.xiong.shop.dto.SelectMenuDTO;
import com.xiong.shop.entity.SysMenu;
import com.xiong.shop.result.ResponseResult;
import com.xiong.shop.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 菜单（权限）表 前端控制器
 * </p>
 *
 * @author xionggaoxiang
 * @since 2020-03-31
 */
@RestController
@RequestMapping("/sysMenu")
@Api(tags = "菜单管理")
public class SysMenuController {

    @Autowired
    private SysMenuService menuService;

    @PostMapping(value = "/create")
    @ApiOperation(value = "创建菜单")
    public ResponseResult create(@RequestBody @Valid MenuCreatelDTO menuCreatelDTO) {
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(menuCreatelDTO, sysMenu);
        return ResponseResult.success(menuService.save(sysMenu));
    }

    @PostMapping(value = "/delete")
    @ApiOperation(value = "删除菜单")
    public ResponseResult delete(@RequestBody @Valid CommonDeleteOrDetailDTO commonDTO) {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setId(commonDTO.getId());
        sysMenu.setDelFlag(true);
        return ResponseResult.success(menuService.updateById(sysMenu));
    }

    @PostMapping(value = "/selectList")
    @ApiOperation(value = "查询菜单列表")
    public ResponseResult selectList(@RequestBody @Valid SelectMenuDTO selectMenuDTO) {
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(selectMenuDTO.getName())) {
            queryWrapper.like("name", selectMenuDTO.getName());
        }
        queryWrapper.eq("del_flag", 0);
        List<SysMenu> list = menuService.list(queryWrapper);
        return ResponseResult.success(list);
    }

    @PostMapping(value = "/selectPage")
    @ApiOperation(value = "查询菜单分页")
    public ResponseResult selectPage(@RequestBody @Valid SelectMenuDTO selectMenuDTO) {
        Page<SysMenu> page = new Page<>();
        page.setSize(selectMenuDTO.getSize());
        page.setCurrent(selectMenuDTO.getCurrent());
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(selectMenuDTO.getName())) {
            queryWrapper.like("name", selectMenuDTO.getName());
        }
        queryWrapper.eq("del_flag", 0);
        IPage<SysMenu> list = menuService.page(page, queryWrapper);
        return ResponseResult.success(list);
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "更新菜单")
    public ResponseResult update(@RequestBody @Valid MenuUpdateDTO menuUpdateDTO) {
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(menuUpdateDTO, sysMenu);
        return ResponseResult.success(menuService.updateById(sysMenu));
    }

    @PostMapping(value = "/detail")
    @ApiOperation(value = "查询菜单详情")
    public ResponseResult detail(@RequestBody @Valid CommonDeleteOrDetailDTO commonDTO) {
        return ResponseResult.success(menuService.getById(commonDTO.getId()));
    }

}
