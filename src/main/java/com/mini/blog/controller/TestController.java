package com.mini.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kpq
 * @since 1.0.0
 */
@RestController
@RequestMapping("/admin/test")
public class TestController {

    @GetMapping
    public String test() {
        return "test";
    }

}
