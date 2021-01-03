package com.mini.blog.enums;


import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 认证失败的类型
 *
 * @author kpq
 * @since 1.0.0
 */
public enum AuthFailureType {

    /**
     * 账户被锁定
     */
    ACCOUNT_LOCKED(HttpStatus.FORBIDDEN.value(), "账户被锁定"),
    /**
     * 密码认证错误
     */
    BAD_CREDENTIALS(HttpStatus.UNAUTHORIZED.value(), "账户或者密码错误"),
    /**
     * 账户不可用
     */
    ACCOUNT_DISABLED(HttpStatus.FORBIDDEN.value(), "账户被禁用"),
    /**
     * 账户过期
     */
    ACCOUNT_EXPIRED(HttpStatus.FORBIDDEN.value(), "账户过期"),
    /**
     * 密码过期
     */
    CREDENTIALS_EXPIRED(HttpStatus.UNAUTHORIZED.value(), "密码过期"),

    /**
     * 认证失败
     */
    AUTH_FAILED(HttpStatus.UNAUTHORIZED.value(), "认证失败");
    /**
     * 状态码
     */
    @Getter
    private Integer code;
    /**
     * 消息
     */
    @Getter
    private String msg;

    AuthFailureType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
