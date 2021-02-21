package com.mini.blog.service;

import cn.hutool.core.net.NetUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.HttpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.collect.Lists;
import com.mini.blog.Constant.CommonConstant;
import com.mini.blog.entity.Comment;
import com.mini.blog.manager.CommentManager;
import com.mini.blog.model.comment.CommentDetails;
import com.mini.blog.model.comment.CommentUser;
import com.mini.blog.model.converter.CommentDetailsConverter;
import com.mini.blog.model.vo.CommentVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author kpq
 * @since 1.0.0
 */
@Service
public class CommentService {

    @Resource
    private CommentManager commentManager;

    @Resource
    private CommentDetailsConverter converter;


    public void insert(Comment comment){
        comment.setCommentStatus(Boolean.TRUE);
        this.commentManager.save(comment);
    }

    /**
     * 根据文章id获取文章评论
     *
     * @param postId
     * @return
     */
    public CommentVO getCommentByPostId(String postId) {
        List<Comment> list = commentManager.list(new LambdaQueryWrapper<>(Comment.class)
                .eq(Comment::getPostId, postId).eq(Comment::getCommentStatus, Boolean.TRUE).orderByDesc(Comment::getCreateTime));
        List<CommentDetails> rootNodes = Lists.newArrayList();
        //获取根结点
        list.stream().filter(e -> CommonConstant.ZERO.equals(e.getParentId())).forEach(e -> {
            CommentDetails commentDetails = converter.convert(e);
            rootNodes.add(commentDetails);
        });
        rootNodes.forEach(e -> buildChildNodes(e, list));
        CommentVO commentVO = CommentVO.builder().commentNum(rootNodes.size()).commentList(rootNodes).build();
        return commentVO;
    }


    /**
     * 递归子结点
     *
     * @param node
     * @param nodes
     */
    private void buildChildNodes(CommentDetails node, List<Comment> nodes) {
        List<CommentDetails> children = this.getChildNodes(node, nodes);
        if (!children.isEmpty()) {
            children.forEach(e -> buildChildNodes(e, nodes));
            node.setChildrenList(children);
        }
    }

    /**
     * 查找子结点
     *
     * @param node
     * @param nodes
     * @return
     */
    private List<CommentDetails> getChildNodes(CommentDetails node, List<Comment> nodes) {
        List<CommentDetails> childNodes = Lists.newArrayList();
        nodes.forEach(e -> {
            if (node.getId().equals(e.getParentId())) {
                CommentDetails details = converter.convert(e);
                details.setTargetUser(CommentUser.builder().id(node.getId())
                        .nickName(node.getCommentUser().getNickName()).build());
                childNodes.add(details);
            }
        });
        return childNodes;
    }
}
