package com.mini.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotBlank
    private String author;

    @ApiModelProperty(value = "邮箱")
    @NotBlank
    private String email;

    @ApiModelProperty(value = "ip地址")
    private String ipAddr;

    @ApiModelProperty(value = "评论文章id")
    @NotBlank
    private String postId;

    @ApiModelProperty(value = "评论内容")
    @NotBlank
    private String content;

    @ApiModelProperty(value = "是否展示评论")
    @NotNull
    private Boolean commentStatus;

    @ApiModelProperty(value = "父评论id")
    @NotBlank
    private String parentId;


}
