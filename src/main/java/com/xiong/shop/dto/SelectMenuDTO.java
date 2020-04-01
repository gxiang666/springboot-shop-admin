package com.xiong.shop.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/4/1
 */
@Data
@ApiModel(value = "SelectMenuDTO", description = "查询参数对象")
public class SelectMenuDTO extends PageQueryDTO {

    @ApiModelProperty(value = "菜单名")
    private String name;
}
