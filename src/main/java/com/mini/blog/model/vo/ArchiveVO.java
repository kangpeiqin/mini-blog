package com.mini.blog.model.vo;

import com.mini.blog.entity.Post;
import com.mini.blog.model.dto.YearPostDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author kpq
 * @since 1.0.0
 */
@Data
@Builder
public class ArchiveVO {

    @ApiModelProperty("文章总数")
    private Long total;

    @ApiModelProperty("每年发表文章总数")
    List<YearPostDTO> list;

}
