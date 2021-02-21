package com.mini.blog.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author kpq
 * @since 1.0.0
 */
@ApiModel(description = "博客列表")
@Data
public class PostListVO {

    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("文章简介")
    private String description;

    @ApiModelProperty("浏览次数")
    private Integer browseTimes;

    @ApiModelProperty("所属分类")
    private String categoryName;

    @ApiModelProperty("文章更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime updateTime;

    @ApiModelProperty("文章更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "封面图片")
    private String coverImage;

    @ApiModelProperty(value = "是否允许被评论")
    @TableField("allowComment")
    private String allowComment;

    @ApiModelProperty("文章标签")
    String tags;
}
