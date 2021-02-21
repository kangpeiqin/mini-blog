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
                        .nickName(comment.getAuthor()).avatar("http://127.0.0.1:8085/image/37d9cae7-16a7-4a94-99d3-bb3966ef8ec0.png").build())
                .content(comment.getContent()).build();
        return commentDetails;
    }
}
