package com.mini.blog.model.dto;

import com.mini.blog.entity.Post;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author kpq
 * @since 1.0.0
 */
@Data
@Builder
public class YearPostDTO {

    @ApiModelProperty("年份")
    private Integer year;

    @ApiModelProperty("发表的文章")
    private List<Post> posts;

}
