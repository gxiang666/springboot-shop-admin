package com.xiong.shop.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/4/1
 */
@Data
@ApiModel(value = "MenuCreatelDTO", description = "菜单创建参数对象")
public class MenuCreatelDTO {
    @ApiModelProperty(value = "菜单名", required = true)
    @NotBlank(message = "菜单名不能为空")
    private String name;
    @ApiModelProperty(value = "菜单英文名", required = true)
    @NotBlank(message = "菜单英文名不能为空")
    private String ename;
    @ApiModelProperty(value = "菜单URL")
    private String url;
    @ApiModelProperty(value = "菜单图标")
    private String icon;
    @ApiModelProperty(value = "父菜单id", required = true)
    @NotNull(message = "parentId不能为空")
    private Integer parentId;
}
