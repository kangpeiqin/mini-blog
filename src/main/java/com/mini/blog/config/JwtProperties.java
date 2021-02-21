package com.mini.blog.config;


import com.mini.blog.Constant.SecurityConstants;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

/**
 * @author kpq
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtProperties {

    /**
     * Jwt 密钥
     */
    private String key;

    /**
     * token 过期时间
     */
    private Long expiration;

    /**
     * 获取加密后的密钥
     *
     * @return
     */
    public SecretKey getSecretKey() {
        final byte[] secretByte = DatatypeConverter.parseBase64Binary(key);
        return Keys.hmacShaKeyFor(secretByte);
    }

}
