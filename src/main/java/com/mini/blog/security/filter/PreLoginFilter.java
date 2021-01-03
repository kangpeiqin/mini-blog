package com.mini.blog.security.filter;

import com.mini.blog.beans.vo.ResultVO;
import com.mini.blog.Constant.SecurityConstants;
import com.mini.blog.utils.JwtUtils;
import com.mini.blog.utils.ResponseUtils;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kpq
 * @since 1.0.0
 */
@Slf4j
public class PreLoginFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (SecurityConstants.LOGIN_URL.equals(request.getRequestURI())
                && HttpMethod.POST.name().equalsIgnoreCase(request.getMethod())) {
            log.debug("过滤请求。。。。。。");
        } else {
            String token = request.getHeader("Authorization");
            if (token == null || !token.startsWith("Bearer")) {
                ResponseUtils.jsonResponse(request, response, ResultVO.error(500, "无权限访问"));
                return;
            }
            try {
                Jwts.parserBuilder().setSigningKey(JwtUtils.SECRET_KEY).build().parseClaimsJws(token.replace("Bearer ", ""));
                filterChain.doFilter(request, response);
                return;
            } catch (Exception e) {
                ResponseUtils.jsonResponse(request, response, ResultVO.error(500, e.getMessage()));
            }
        }
        filterChain.doFilter(request, response);
    }
}
