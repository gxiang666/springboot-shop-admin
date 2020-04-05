package com.xiong.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiong.shop.entity.SysMenu;

import java.util.List;

/**
 * <p>
 * 菜单（权限）表 Mapper 接口
 * </p>
 *
 * @author xionggaoxiang
 * @since 2020-03-31
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 通过用户id查询用户拥有的菜单列表
     *
     * @param id
     * @return
     */
    List<SysMenu> selectMenuListByUserId(Long id);

}
