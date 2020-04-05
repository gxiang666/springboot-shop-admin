package com.xiong.shop.security;

import com.xiong.shop.entity.SysUser;
import com.xiong.shop.result.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/4/5
 */
@RestController
@Api(tags = "安全接口")
@RequestMapping(value = "/security")
public class SecurityController {

    /**
     * 获取认证信息
     *
     * @param authentication IOC容器会自动注入
     * @return
     */
    @PostMapping("/authentication/autowired")
    @ApiOperation(value = "获取认证信息（通过自动注入）")
    public ResponseResult getAuthentication(Authentication authentication) {
        return ResponseResult.success(authentication);
    }

    /**
     * 获取认证信息
     *
     * @return
     */
    @PostMapping("/authentication/code")
    @ApiOperation(value = "获取认证信息（通过代码）")
    public ResponseResult getAuthentication() {
        return ResponseResult.success(SecurityContextHolder.getContext().getAuthentication());
    }

    /**
     * 获取当前用户
     *
     * @param authentication IOC容器会自动注入
     * @return
     */
    @PostMapping("/currentUser")
    @ApiOperation(value = "获取当前用户")
    public ResponseResult getAuthenticationUser(@AuthenticationPrincipal SysUser authentication) {
        return ResponseResult.success(authentication);
    }

}
