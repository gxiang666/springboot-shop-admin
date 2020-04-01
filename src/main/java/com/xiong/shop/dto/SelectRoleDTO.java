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
public class SelectRoleDTO extends PageQueryDTO {

    @ApiModelProperty(value = "角色名")
    private String ename;
}
