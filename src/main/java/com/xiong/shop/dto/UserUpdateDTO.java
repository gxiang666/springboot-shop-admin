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
@ApiModel(value = "UserUpdateDTO", description = "用户更新参数对象")
public class UserUpdateDTO {
    @ApiModelProperty(value = "id", required = true)
    @NotNull(message = "id不能为空")
    private Long id;
    @ApiModelProperty(value = "用户名", required = true)
    @NotBlank(message = "用户名不能为空")
    private String username;
}
