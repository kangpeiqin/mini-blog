package com.mini.blog.manager;

import com.mini.blog.entity.Post;
import com.mini.blog.mapper.PostMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章发布表  服务实现类
 * </p>
 *
 * @author generator
 * @since 2020-11-29
 */
@Service
public class PostManager extends ServiceImpl<PostMapper, Post>  {

}
