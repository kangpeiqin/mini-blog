package com.mini.blog.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mini.blog.beans.vo.PostListVO;
import com.mini.blog.entity.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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

    IPage<PostListVO> findPage(IPage<PostListVO> page);
}
