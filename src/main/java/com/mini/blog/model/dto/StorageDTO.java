package com.mini.blog.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.MediaType;

/**
 * @author kpq
 * @since 1.0.0
 */
@Data
@Builder
public class StorageDTO {

    @ApiModelProperty("文件名")
    private String filename;

    @ApiModelProperty("存储路径")
    private String url;

    @ApiModelProperty("key")
    private String key;
}
