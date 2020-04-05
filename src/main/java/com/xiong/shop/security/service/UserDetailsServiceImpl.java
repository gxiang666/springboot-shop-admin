package com.xiong.shop.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiong.shop.entity.SysMenu;
import com.xiong.shop.entity.SysUser;
import com.xiong.shop.mapper.SysMenuMapper;
import com.xiong.shop.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/4/5
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysMenuMapper menuMapper;

    /**
     * Spring Security获取用户逻辑
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username).eq("del_flag", 0);
        SysUser sysUser = userMapper.selectOne(queryWrapper);
        if (Objects.isNull(sysUser)) {
            throw new UsernameNotFoundException("用户不存在");
        }
        // 查询用户拥有的菜单列表
        List<SysMenu> menuList = menuMapper.selectMenuListByUserId(sysUser.getId());
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        for (SysMenu sysMenu : menuList) {
            authorities.add(new SimpleGrantedAuthority(sysMenu.getEname()));
        }
        sysUser.setAuthorities(authorities);
        return sysUser;
    }
}
