package com.xiong.shop.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/4/1
 */
@Data
@ApiModel(value = "RoleCreatelDTO", description = "角色创建参数对象")
public class RoleCreatelDTO {
    @ApiModelProperty(value = "角色名", required = true)
    @NotBlank(message = "角色名不能为空")
    private String name;

    @ApiModelProperty(value = "角色英文名", required = true)
    @NotBlank(message = "角色英文名不能为空")
    private String ename;
}
