package com.mini.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mini.blog.mapper.CategoryMapper;
import com.mini.blog.mapper.PostMapper;
import com.mini.blog.model.vo.CategoryVO;
import com.mini.blog.model.vo.PostListVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author kpq
 * @since 1.0.0
 */
@Service
public class CategoryService {

    @Resource
    private CategoryMapper categoryMapper;


    @Resource
    private PostMapper postMapper;

    public IPage<CategoryVO> listAll(Long pageNum, Long pageSize) {
        return categoryMapper.findPage(new Page<>(pageNum, pageSize));
    }

    public IPage<PostListVO> listPostByCategoryId(Long pageNum, Long pageSize, String categoryId) {
        return postMapper.findByCategoryId(new Page<>(pageNum, pageSize), categoryId);
    }

}
