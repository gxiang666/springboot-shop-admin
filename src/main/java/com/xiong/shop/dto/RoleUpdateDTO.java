package com.xiong.shop.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/4/1
 */
@Data
@ApiModel(value = "RoleUpdateDTO", description = "菜单更新参数对象")
public class RoleUpdateDTO {

    @Min(1)
    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "id", required = true)
    private Integer id;

    @ApiModelProperty(value = "角色名", required = true)
    @NotBlank(message = "角色名不能为空")
    private String name;

    @ApiModelProperty(value = "角色英文名", required = true)
    @NotBlank(message = "角色英文名不能为空")
    private String ename;
}
