package com.mini.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mini.blog.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 客户端信息表
 * </p>
 *
 * @author generator
 * @since 2021-01-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_client")
@ApiModel(value="Client对象", description="客户端信息表")
public class Client extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "客户端名称")
    private String clientId;

    @ApiModelProperty(value = "客户端密钥")
    private String clientSecret;

    @ApiModelProperty(value = "权限")
    private String scope;

    @ApiModelProperty(value = "状态：0：不可用，1：可用")
    private Boolean state;


}
