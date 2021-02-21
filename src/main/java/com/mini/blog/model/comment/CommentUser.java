package com.mini.blog.model.comment;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @author kpq
 * @since 1.0.0
 */
@Data
@Builder
public class CommentUser {

    @ApiModelProperty("评论者id")
    private String id;

    @ApiModelProperty("评论者昵称")
    private String nickName;

    private String avatar;
}
