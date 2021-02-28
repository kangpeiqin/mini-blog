package com.mini.blog.security.filter;

import com.mini.blog.Constant.SecurityConstants;
import com.mini.blog.model.vo.ResultVO;
import com.mini.blog.utils.JwtUtils;
import com.mini.blog.utils.ResponseUtils;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Jwt认证过滤器
 *
 * @author kpq
 * @since 1.0.0
 */

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private SecretKey secretKey;
    private PathMatcher pathMatcher = new AntPathMatcher();


    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, SecretKey secretKey) {
        super(authenticationManager);
        this.secretKey = secretKey;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (pathMatcher.matchStart(request.getRequestURI(), SecurityConstants.ADMIN_PREFIX)) {
            String token = request.getHeader(SecurityConstants.TOKEN_HEADER);
            if (token == null || !token.startsWith(SecurityConstants.TOKEN_PREFIX)) {
                SecurityContextHolder.clearContext();
                ResultVO result = ResultVO.error(HttpStatus.UNAUTHORIZED.value(),"无访问权限");
                ResponseUtils.jsonResponse(request, response, result);
                return;
            }
            String tokenValue = token.replace(SecurityConstants.TOKEN_PREFIX, "");
            UsernamePasswordAuthenticationToken authentication = null;
            try {
                authentication = JwtUtils.getAuthentication(tokenValue, secretKey);
            } catch (JwtException e) {
                logger.error("Invalid jwt : " + e.getMessage());
                ResponseUtils.jsonResponse(request, response, ResultVO.error(HttpStatus.FORBIDDEN.value(), "无权限访问"));
            }
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }
}
