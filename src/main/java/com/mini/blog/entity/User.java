package com.mini.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mini.blog.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author generator
 * @since 2020-11-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tb_user")
@ApiModel(value = "User对象", description = " 用户信息表")
public class User extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名:保证唯一")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "账户是否可用")
    private Boolean enabled;

    @ApiModelProperty(value = "账户是否过期")
    private String expired;

    @ApiModelProperty(value = "账户是否被锁定")
    private Boolean locked;


}
