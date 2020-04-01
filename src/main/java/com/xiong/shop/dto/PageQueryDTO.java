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
@ApiModel(value = "分页查询对象")
public class PageQueryDTO {

    @Min(1)
    @NotNull(message = "current不能为空")
    @ApiModelProperty(value = "当前页默认为1", required = true)
    private Integer current = 1;

    @Min(1)
    @NotNull(message = "size不能为空")
    @ApiModelProperty(value = "页容量，默认为10", required = true)
    private Integer size = 10;

}
