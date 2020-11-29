package com.mini.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mini.blog.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 分类表 
 * </p>
 *
 * @author generator
 * @since 2020-11-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_category")
@ApiModel(value="Category对象", description="分类表 ")
public class Category extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分类名称")
    private String name;


}
