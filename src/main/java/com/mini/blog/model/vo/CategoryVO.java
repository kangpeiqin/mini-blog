package com.mini.blog.model.vo;

import com.mini.blog.entity.Category;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author kpq
 * @since 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CategoryVO extends Category{

    @ApiModelProperty("该分类下的文章总数")
    private Long postNum;

}
