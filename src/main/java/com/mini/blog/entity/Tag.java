package com.mini.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mini.blog.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 标签表
 * </p>
 *
 * @author generator
 * @since 2020-11-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_tag")
@ApiModel(value="Tag对象", description="标签表")
public class Tag extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标签名称")
    private String name;


}
