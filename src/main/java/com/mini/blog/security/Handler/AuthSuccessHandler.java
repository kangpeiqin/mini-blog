package com.mini.blog.security.Handler;

import com.mini.blog.entity.AccountDetails;
import com.mini.blog.model.vo.ResultVO;
import com.mini.blog.config.JwtProperties;
import com.mini.blog.entity.User;
import com.mini.blog.utils.JwtUtils;
import com.mini.blog.utils.ResponseUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kpq
 * @since 1.0.0
 */
@Component
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    @Resource
    private JwtProperties jwtProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //认证成功后创建token
        User user = ((AccountDetails) authentication.getPrincipal()).getUser();
        String token = JwtUtils.generateToken(user.getId().toString(), user.getUsername(), jwtProperties.getExpiration(), jwtProperties.getSecretKey());
        ResponseUtils.jsonResponse(request, response, ResultVO.success(token));
    }
}
