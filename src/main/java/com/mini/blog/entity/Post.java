package com.mini.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mini.blog.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 文章发布表 
 * </p>
 *
 * @author generator
 * @since 2020-11-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_post")
@ApiModel(value="Post对象", description="文章发布表 ")
public class Post extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "文章简介")
    private String description;

    @ApiModelProperty(value = "原始内容")
    private String originalContent;

    @ApiModelProperty(value = "格式化内容")
    private String formatContent;

    @ApiModelProperty(value = "发布状态")
    private String postStatus;

    @ApiModelProperty(value = "发布的链接")
    private String url;

    @ApiModelProperty(value = "浏览次数")
    private Long browseTimes;

    @ApiModelProperty(value = "文章的所属的分类")
    private String categoryId;

    @ApiModelProperty(value = "是否允许被评论")
    @TableField("allowComment")
    private String allowcomment;

    @ApiModelProperty(value = "文章是否被推荐")
    private String recommend;


}
