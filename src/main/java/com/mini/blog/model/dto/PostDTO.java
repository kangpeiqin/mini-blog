package com.mini.blog.model.dto;

import com.mini.blog.entity.Post;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @author kpq
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PostDTO extends Post {

    @ApiModelProperty("文章的标签集合")
    private Set<String> tagIds;

}
