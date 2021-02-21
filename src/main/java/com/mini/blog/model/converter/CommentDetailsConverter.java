package com.mini.blog.model.converter;

import com.mini.blog.entity.Comment;
import com.mini.blog.model.comment.CommentDetails;
import com.mini.blog.model.comment.CommentUser;
import org.springframework.stereotype.Component;

/**
 * @author kpq
 * @since 1.0.0
 */
@Component
public class CommentDetailsConverter {

    public CommentDetails convert(Comment comment) {
        CommentDetails commentDetails = CommentDetails.builder().
                id(comment.getId()).createDate(comment.getCreateTime().toString())
                .commentUser(CommentUser.builder().id(comment.getIpAddr())
                        .nickName(comment.getAuthor()).build())
                .content(comment.getContent()).build();
        return commentDetails;
    }
}
