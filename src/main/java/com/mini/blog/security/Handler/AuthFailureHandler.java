package com.mini.blog.security.Handler;

import com.mini.blog.model.vo.ResultVO;
import com.mini.blog.enums.AuthFailureType;
import com.mini.blog.utils.ResponseUtils;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败处理器
 *
 * @author kpq
 * @since 1.0.0
 */
@Component
public class AuthFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        ResultVO result;
        if (e instanceof BadCredentialsException) {
            result = authFailureType(AuthFailureType.BAD_CREDENTIALS);
        } else if (e instanceof DisabledException) {
            result = authFailureType(AuthFailureType.ACCOUNT_DISABLED);
        } else if (e instanceof LockedException) {
            result = authFailureType(AuthFailureType.ACCOUNT_LOCKED);
        } else if (e instanceof AccountExpiredException) {
            result = authFailureType(AuthFailureType.ACCOUNT_EXPIRED);
        } else if (e instanceof CredentialsExpiredException) {
            result = authFailureType(AuthFailureType.CREDENTIALS_EXPIRED);
        } else {
            result = authFailureType(AuthFailureType.AUTH_FAILED);
        }
        ResponseUtils.jsonResponse(request, response, result);
    }

    private ResultVO authFailureType(AuthFailureType type) {
        return ResultVO.error(type.getCode(), type.getMsg());
    }
}
