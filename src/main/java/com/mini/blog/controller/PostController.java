package com.mini.blog.controller;

import com.mini.blog.entity.Post;
import com.mini.blog.model.dto.common.BaseDTO;
import com.mini.blog.model.dto.PostDTO;
import com.mini.blog.model.vo.ResultVO;
import com.mini.blog.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author kpq
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/post")
@Api(tags = "博文列表")
public class PostController {

    @Resource
    private PostService postService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "分页数", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页大小", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "keyWord", value = "查询关键字", dataType = "String", paramType = "query")
    })
    @GetMapping
    @ApiOperation("文章分页列表")
    public ResultVO findPage(@RequestParam(value = "pageNum", defaultValue = "1") Long pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") Long pageSize,
                             @RequestParam(value = "keyWord", required = false) String keyWord) {
        return ResultVO.success(postService.findPage(pageNum, pageSize, keyWord));
    }

    @GetMapping("{postId:\\w+}")
    @ApiOperation("文章具体内容")
    public ResultVO<Post> getById(@PathVariable("postId") String postId) {
        return ResultVO.success(postService.getById(postId));
    }

    @PostMapping
    @ApiOperation("新增")
    public ResultVO insert(@Valid @RequestBody PostDTO postDTO) {
        postService.insert(postDTO);
        return ResultVO.success(null);
    }

    @PutMapping
    @ApiOperation("更新")
    public ResultVO update(@Valid @RequestBody PostDTO postDTO) {
        postService.update(postDTO);
        return ResultVO.success(null);
    }

    @DeleteMapping
    @ApiOperation("删除")
    public ResultVO delete(@Valid @RequestBody BaseDTO baseDTO) {
        postService.delete(baseDTO.getIds());
        return ResultVO.success(null);
    }

    @GetMapping("/archives")
    @ApiOperation("归档")
    public ResultVO archives(@RequestParam(value = "pageNum",defaultValue = "1") Long pageNum, @RequestParam(value = "pageSize",required = false,defaultValue = "10") Long pageSize) {
        return ResultVO.success(postService.getArchive(pageNum, pageSize));
    }

}
