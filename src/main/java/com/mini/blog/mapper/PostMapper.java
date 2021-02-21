package com.mini.blog.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mini.blog.model.vo.PostListVO;
import com.mini.blog.entity.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 文章发布表  Mapper 接口
 * </p>
 *
 * @author generator
 * @since 2020-12-01
 */
@Mapper
public interface PostMapper extends BaseMapper<Post> {

    /**
     * 文章列表分页查询
     *
     * @param page
     * @param keyWord
     * @return
     */
    IPage<PostListVO> findPage(IPage<PostListVO> page, @Param("keyWord") String keyWord);


    /**
     * 根据分类id获取文章列表
     *
     * @param page
     * @param categoryId
     * @return
     */
    IPage<PostListVO> findByCategoryId(IPage<PostListVO> page, @Param("categoryId") String categoryId);

    /**
     * 博文分页查询
     * @param page
     * @return
     */
    IPage<Post> listByPage(IPage<Post> page);
}
