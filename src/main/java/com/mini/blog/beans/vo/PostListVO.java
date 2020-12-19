package com.mini.blog.beans.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
    private Long id;

    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("文章简介")
    private String description;

    @ApiModelProperty("浏览次数")
    private Integer browseTimes;

    @ApiModelProperty("所属分类")
    private String categoryName;

    @ApiModelProperty("文章更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("文章标签")
    String tags;
}
