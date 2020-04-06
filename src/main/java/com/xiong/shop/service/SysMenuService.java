package com.xiong.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiong.shop.entity.SysMenu;

import java.util.List;

/**
 * <p>
 * 菜单（权限）表 服务类
 * </p>
 *
 * @author xionggaoxiang
 * @since 2020-03-31
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 查询用户拥有的菜单权限
     *
     * @param userId
     * @return
     */
    List<SysMenu> selecCurrentUsertMenuTree(Long userId);
}
