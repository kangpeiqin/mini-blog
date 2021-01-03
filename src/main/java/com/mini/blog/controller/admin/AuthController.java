package com.mini.blog.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author kpq
 * @since 1.0.0
 */
@RestController
@RequestMapping("/auth")
@Slf4j
@Api(tags = "认证")
public class AuthController {

    @PostMapping("/login")
    @ApiOperation("登录认证")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String")
    })
    public ResponseEntity<Void> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
}
