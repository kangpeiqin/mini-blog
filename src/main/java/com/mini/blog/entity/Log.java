package com.mini.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mini.blog.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 日志表 
 * </p>
 *
 * @author generator
 * @since 2020-11-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_log")
@ApiModel(value="Log对象", description="日志表 ")
public class Log extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "日志内容")
    private String content;

    @ApiModelProperty(value = "访问ip地址记录")
    private String ipAddr;


}
