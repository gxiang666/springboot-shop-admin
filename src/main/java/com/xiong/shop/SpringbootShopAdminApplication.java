package com.xiong.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @author xionggaoxiang
 * @since 2020-03-31
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SpringbootShopAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootShopAdminApplication.class, args);
    }

}
