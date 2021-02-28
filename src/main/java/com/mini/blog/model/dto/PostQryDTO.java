package com.mini.blog.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author kpq
 * @since 1.0.0
 */
@Data
@Builder
public class PostQryDTO {

    @ApiModelProperty("搜索文章标题关键字")
    private String keyWord;

    @ApiModelProperty("文章发布状态")
    private String postStatus;
}
