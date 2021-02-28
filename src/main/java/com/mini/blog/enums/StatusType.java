package com.mini.blog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author kpq
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum StatusType {
    /**
     * 发布装填
     */
    POST_STATUS(0, "postStatus"),

    /**
     * 是否允许评论状态
     */
    AllOW_COMMENT_STATUS(1, "allowCommentStatus"),


    /**
     * 是否推荐状态
     */
    RECOMMEND_STATUS(2, "recommendStatus");

    private Integer code;
    private String name;

}
