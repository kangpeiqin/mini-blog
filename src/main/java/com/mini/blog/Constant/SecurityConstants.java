package com.mini.blog.Constant;

/**
 * @author kpq
 * @since 1.0.0
 */
public class SecurityConstants {
    /**
     * rememberMe 为 false 的时候过期时间是1个小时
     */
    public static final long EXPIRATION = 60 * 60L;

    /**
     * rememberMe 为 true 的时候过期时间是7天
     */
    public static final long EXPIRATION_REMEMBER = 60 * 60 * 24 * 7L;

    public static final String JWT_SECRET_KEY = "C*F-JaNdRgUkXn2r5u8x/A?D(G+KbPeShVmYq3s6v9y$B&E)H@McQfTjWnZr4u7w";

    public static final String LOGIN_URL = "/auth/login";
    /**
     * swagger文档请求路径
     */
    public static final String[] SWAGGER_WHITELIST = {
            "/doc.html",
            "/swagger-ui/*",
            "/swagger-resources/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/webjars/**",
            "/content/**"
    };
}
