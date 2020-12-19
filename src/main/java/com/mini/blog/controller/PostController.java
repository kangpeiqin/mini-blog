package com.mini.blog.controller;

import com.mini.blog.beans.vo.ResultVO;
import com.mini.blog.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author kpq
 * @since 1.0.0
 */
@RestController
@RequestMapping("/content")
@Api(tags = "博文列表")
public class PostController {

    @Resource
    private PostService postService;

    @GetMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "分页数", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页大小", dataType = "Long", paramType = "query")
    })
    public ResultVO findPage(@RequestParam(value = "pageNum", defaultValue = "1") Long pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") Long pageSize) {
        return ResultVO.success(postService.findPage(pageNum, pageSize));
    }

}
