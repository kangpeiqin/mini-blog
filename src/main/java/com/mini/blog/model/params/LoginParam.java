package com.mini.blog.model.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author kpq
 * @since 1.0.0
 */
@Data
@ApiModel("登录参数")
@Builder
public class LoginParam {

    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名或者邮箱不能为空")
    @Size(max = 255, message = "用户名或者邮箱不能超过 {max}")
    private String username;

    @ApiModelProperty("密码")
    @NotBlank(message = "登录密码不能为空")
    @Size(min = 6, message = "用户密码字符长度不能少于 {min}")
    private String password;

    @ApiModelProperty("验证码")
    @Size(min = 6, max = 6, message = "验证码应为{max}位")
    private String authCode;
}
