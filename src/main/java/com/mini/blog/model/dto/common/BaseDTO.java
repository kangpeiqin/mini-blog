package com.mini.blog.model.dto.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author kpq
 * @since 1.0.0
 */
@Data
public class BaseDTO {

    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("主键数组")
    private String[] ids;

    @ApiModelProperty("状态")
    private Boolean status;

    @ApiModelProperty("状态的类型")
    private Integer type;

}
