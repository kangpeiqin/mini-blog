package com.mini.blog.utils;

import com.mini.blog.Constant.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.List;

/**
 * 参考文档：https://github.com/jwtk/jjwt#jws-key-create-secret
 *
 * @author kpq
 * @since 1.0.0
 */
public class JwtUtils {

//    /**
//     * 生成足够的安全随机密钥，以适合符合规范的签名
//     */
//
//    private static final byte[] API_KEY_SECRET_BYTES = DatatypeConverter.parseBase64Binary(SecurityConstants.JWT_SECRET_KEY);
//    public static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(API_KEY_SECRET_BYTES);
//
//    /**
//     * 生成token
//     */
//    public static String createToken(String username, String id, boolean isRememberMe) {
//        long expiration = isRememberMe ? SecurityConstants.EXPIRATION_REMEMBER : SecurityConstants.EXPIRATION;
//        final Date createdDate = new Date();
//        final Date expirationDate = new Date(createdDate.getTime() + expiration * 1000);
//        String token = Jwts.builder()
//                .setHeaderParam("type", "JWT")
//                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
//                .setId(id)
//                .setIssuer("admin")
//                .setIssuedAt(createdDate)
//                .setSubject(username)
//                .setExpiration(expirationDate)
//                .compact();
//        return SecurityConstants.TOKEN_PREFIX + token;
//    }

    /**
     * 生成token
     *
     * @param id
     * @param username
     * @param expiration
     * @param secretKey
     * @return
     */
    public static String generateToken(String id, String username, Long expiration, SecretKey secretKey) {
        Date generateDate = new Date();
        final Date expirationDate = new Date(generateDate.getTime() + expiration * 1000*3600);
        String token = Jwts.builder()
                .setId(id)
                .setHeaderParam("type", "JWT")
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .setIssuer("admin")
                .setIssuedAt(generateDate)
                .setSubject(username)
                .setExpiration(expirationDate)
                .compact();
        return SecurityConstants.TOKEN_PREFIX + token;
    }

    /**
     * 通过token获取登录凭证
     *
     * @param token
     * @param secretKey
     * @return
     */
    public static UsernamePasswordAuthenticationToken getAuthentication(String token, SecretKey secretKey) {
        Claims claims = getClaims(token, secretKey);
        String userName = claims.getSubject();
        return new UsernamePasswordAuthenticationToken(userName, token, null);
    }


    /**
     * 解析token,获取身份凭证
     *
     * @param token
     * @param secretKey
     * @return
     */
    public static Claims getClaims(String token, SecretKey secretKey) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
    }


    public static void main(String[] args) {
        //利用HMAC-SHA算法生成一个随机密钥
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String secretString = Encoders.BASE64.encode(key.getEncoded());
        System.out.println(secretString);
    }
}
