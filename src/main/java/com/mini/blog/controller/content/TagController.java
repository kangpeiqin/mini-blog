package com.mini.blog.controller.content;

import com.mini.blog.manager.TagManager;
import com.mini.blog.model.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author kpq
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/tag")
@Api(tags = "标签内容")
public class TagController {

    @Resource
    private TagManager tagManager;

    @GetMapping("/all")
    @ApiOperation("查找所有标签")
    public ResultVO listAll() {
        return ResultVO.success(tagManager.list());
    }

}
