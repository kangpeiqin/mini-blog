package com.mini.blog.model.vo;

import com.mini.blog.model.comment.CommentDetails;
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
public class CommentVO {

    @ApiModelProperty("评论总条数")
    private Integer commentNum;

    @ApiModelProperty("作者id")
    private String authorId;

    private List<CommentDetails> commentList;

}
