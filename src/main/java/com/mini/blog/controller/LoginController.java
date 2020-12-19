package com.mini.blog.controller;

import com.mini.blog.beans.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kpq
 * @since 1.0.0
 */
@RestController
@Api("登录接口")
public class LoginController {

    @PostMapping("/login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String")
    })
    public ResultVO login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return ResultVO.success("登录成功");
    }
}
