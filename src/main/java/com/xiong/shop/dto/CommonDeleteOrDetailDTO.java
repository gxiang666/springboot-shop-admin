package com.xiong.shop.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Author: XiongGaoXiang
 * @Date: 2020/4/1
 */
@Data
@ApiModel(value = "CommonDeleteOrDetailDTO", description = "通用的删除或者详情参数对象")
public class CommonDeleteOrDetailDTO {

    @Min(1)
    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "id", required = true)
    private Integer id;
}
