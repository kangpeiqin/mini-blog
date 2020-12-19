package com.mini.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mini.blog.beans.vo.PostListVO;
import com.mini.blog.entity.Post;
import com.mini.blog.mapper.PostMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author kpq
 * @since 1.0.0
 */
@Service
public class PostService {

    @Resource
    private PostMapper postMapper;

    /**
     * 文章展示分页
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public IPage<PostListVO> findPage(Long pageNum, Long pageSize) {
        return postMapper.findPage(new Page<>(pageNum, pageSize));
    }

}
