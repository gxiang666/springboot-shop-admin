package com.xiong.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiong.shop.entity.SysMenu;
import com.xiong.shop.mapper.SysMenuMapper;
import com.xiong.shop.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 菜单（权限）表 服务实现类
 * </p>
 *
 * @author xionggaoxiang
 * @since 2020-03-31
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuMapper menuMapper;

    /**
     * @param userId
     * @return
     */
    @Override
    public List<SysMenu> selecCurrentUsertMenuTree(Long userId) {
        List<SysMenu> sourceList = null;
        List<SysMenu> targetList = new ArrayList<>();
        if (Objects.isNull(userId)) {
            QueryWrapper<SysMenu> wrapper = new QueryWrapper<>();
            wrapper.eq("del_flag", 0);
            sourceList = this.list(wrapper);
        } else {
            sourceList = menuMapper.selectMenuListByUserId(userId);
        }
        for (SysMenu sysMenu : sourceList) {
            if (sysMenu.getParentId().equals(0)) {
                targetList.add(sysMenu);
            }
        }
        findMenuChilren(sourceList, targetList);
        return targetList;
    }

    /**
     * 查询子菜单
     *
     * @param sourceList
     * @param targetList
     */
    private void findMenuChilren(List<SysMenu> sourceList, List<SysMenu> targetList) {

        if (targetList.size() == 0) {
            return;
        }

        for (SysMenu targetMenu : targetList) {
            ArrayList<SysMenu> chilrenList = new ArrayList<>();
            for (SysMenu sourceMenu : sourceList) {
                if (sourceMenu.getParentId().equals(targetMenu.getId())) {
                    chilrenList.add(sourceMenu);
                }
            }
            findMenuChilren(sourceList, chilrenList);
            targetMenu.setMenuList(chilrenList);
        }

    }


}
