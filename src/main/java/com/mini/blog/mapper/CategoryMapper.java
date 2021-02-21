package com.mini.blog.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mini.blog.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mini.blog.model.vo.CategoryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 分类表  Mapper 接口
 * </p>
 *
 * @author generator
 * @since 2020-11-29
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 类别分页查找
     *
     * @param page
     * @return
     */
    IPage<CategoryVO> findPage(@Param("page") Page<CategoryVO> page);

}
