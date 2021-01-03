package com.mini.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mini.blog.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名:保证唯一")
    @NotBlank(message = "用户名或者邮箱不能为空")
    @Size(max = 255, message = "用户名或者邮箱不能超过 {max}")
    private String username;

    @ApiModelProperty(value = "密码")
    @NotBlank(message = "登录密码不能为空")
    @Size(min = 6, message = "用户密码字符长度不能少于 {min}")
    private String password;

    @ApiModelProperty(value = "账户是否可用")
    private Boolean enabled;

    @ApiModelProperty(value = "账户是否过期")
    private Boolean expired;

    @ApiModelProperty(value = "账户是否被锁定")
    private Boolean locked;


}
