package com.mini.blog.model.comment;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author kpq
 * @since 1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDetails {

    @ApiModelProperty("评论条目id")
    private String id;

    @ApiModelProperty("评论创建时间")
    private String createDate;

    @ApiModelProperty("评论用户")
    private CommentUser commentUser;

    @ApiModelProperty("被评论用户")
    private CommentUser targetUser;

    @ApiModelProperty("评论内容")
    private String content;

    @ApiModelProperty("子评论")
    private List<CommentDetails> childrenList;
}
