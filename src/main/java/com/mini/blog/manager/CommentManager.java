package com.mini.blog.manager;

import com.mini.blog.entity.Comment;
import com.mini.blog.mapper.CommentMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author generator
 * @since 2020-11-29
 */
@Service
public class CommentManager extends ServiceImpl<CommentMapper, Comment>  {

}
