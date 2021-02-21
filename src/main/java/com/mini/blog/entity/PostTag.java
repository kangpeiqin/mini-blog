package com.mini.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mini.blog.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 文章标签关联表
 * </p>
 *
 * @author generator
 * @since 2020-12-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_post_tag")
@ApiModel(value = "PostTag对象", description = " 文章标签关联表 ")
public class PostTag extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文章id")
    private String postId;

    @ApiModelProperty(value = "标签id")
    private String tagId;


}
