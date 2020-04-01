package com.xiong.shop.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/4/1
 */
@Data
@ApiModel(value = "SelectUserDTO", description = "查询参数对象")
public class SelectUserDTO extends PageQueryDTO {
    @ApiModelProperty(value = "用户名")
    private String username;
}
