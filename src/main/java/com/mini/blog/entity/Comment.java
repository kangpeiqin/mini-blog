package com.mini.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mini.blog.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author generator
 * @since 2020-11-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_comment")
@ApiModel(value="Comment对象", description="评论表")
public class Comment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论者")
    private String author;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "ip地址")
    private String ipAddr;

    @ApiModelProperty(value = "评论文章id")
    private Long postId;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "是否展示评论")
    private String commentStatus;

    @ApiModelProperty(value = "父评论id")
    private Long parentId;


}
