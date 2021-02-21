package com.mini.blog.controller;

import cn.hutool.extra.servlet.ServletUtil;
import com.mini.blog.entity.Comment;
import com.mini.blog.model.vo.CommentVO;
import com.mini.blog.model.vo.ResultVO;
import com.mini.blog.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;

/**
 * @author kpq
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/comment/")
@Api(tags = "文章评论")
public class CommentController {

    @Resource
    private CommentService commentService;

    @GetMapping("{postId:\\w+}")
    @ApiOperation("根据文章id获取评论列表")
    public ResultVO<CommentVO> getCommentByPostId(@PathVariable("postId") String postId) {
        return ResultVO.success(commentService.getCommentByPostId(postId));
    }

    @PostMapping
    @ApiOperation("增加文章评论")
    public ResultVO insert(@RequestBody @Valid Comment comment, HttpServletRequest request) {
        LocalDate localDate = LocalDate.now();
        comment.setCreateTime(localDate);
        comment.setUpdateTime(localDate);
        comment.setIpAddr(ServletUtil.getClientIP(request));
        commentService.insert(comment);
        return ResultVO.success(null);
    }
}
