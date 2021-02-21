package com.mini.blog.security.filter;

import cn.hutool.core.lang.Validator;
import cn.hutool.http.HttpStatus;
import com.mini.blog.model.vo.ResultVO;
import com.mini.blog.Constant.SecurityConstants;
import com.mini.blog.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
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

    private PathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //登录参数预校验
        if (pathMatcher.match(SecurityConstants.LOGIN_URL, request.getRequestURI())) {
            String username = request.getParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY);
            String password = request.getParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY);
            if (!Validator.isEmail(username)) {
                ResponseUtils.jsonResponse(request, response, ResultVO.error(HttpStatus.HTTP_BAD_REQUEST, "请输入正确的邮箱"));
            }
            if (Validator.isEmpty(password.trim())) {
                ResponseUtils.jsonResponse(request, response, ResultVO.error(HttpStatus.HTTP_BAD_REQUEST, "密码不能为空"));
            }
        }
        filterChain.doFilter(request, response);
    }
}
