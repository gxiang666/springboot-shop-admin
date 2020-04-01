package com.xiong.shop;

import com.xiong.shop.entity.SysMenu;
import com.xiong.shop.entity.SysUser;
import com.xiong.shop.mapper.SysMenuMapper;
import com.xiong.shop.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootShopAdminApplicationTests {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysMenuMapper menuMapper;

    @Test
    void contextLoads() {
        SysUser user = new SysUser();
        user.setUsername("development");
        user.setPassword("{bcrypt}$2a$10$z3NpWIaH3vM7iZ.OP4CCv./M3.2S0Cfys5HpQx2SVTpiS3DVlcbmO");
        user.setDelFlag(true);
        userMapper.insert(user);
    }

    @Test
    void testMenu() {
    }

}
