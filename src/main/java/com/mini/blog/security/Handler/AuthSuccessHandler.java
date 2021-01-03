package com.mini.blog.security.Handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mini.blog.beans.model.AccountDetails;
import com.mini.blog.beans.vo.ResultVO;
import com.mini.blog.entity.User;
import com.mini.blog.utils.JwtUtils;
import com.mini.blog.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

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

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //认证成功后创建token
        User user = ((AccountDetails) authentication.getPrincipal()).getUser();
        String token = JwtUtils.createToken(user.getUsername(), user.getId().toString(), true);
        ResponseUtils.jsonResponse(request, response, ResultVO.success(token));
    }
}
