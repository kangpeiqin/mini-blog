package com.mini.blog.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author kpq
 * @since 1.0.0
 */
@Data
@ApiModel(value = "实体类公共字段", description = "实体类公共字段")
public class BaseEntity implements Serializable {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("创建时间")
    private LocalDate createTime;

    @ApiModelProperty("更新时间")
    private LocalDate updateTime;
}
