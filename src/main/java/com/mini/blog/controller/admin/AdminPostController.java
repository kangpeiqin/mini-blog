package com.mini.blog.controller.admin;

import com.mini.blog.model.dto.PostDTO;
import com.mini.blog.model.dto.common.BaseDTO;
import com.mini.blog.model.vo.ResultVO;
import com.mini.blog.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author kpq
 * @since 1.0.0
 */
@RestController
@RequestMapping("/admin/post")
@Api(tags = "文章管理")
public class AdminPostController {

    @Resource
    private PostService postService;

    @PostMapping
    @ApiOperation("新增")
    public ResultVO insert(@Valid @RequestBody PostDTO postDTO) {
        postDTO.setBrowseTimes(0L);
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
    public ResultVO delete(@RequestParam("id") String id) {
        postService.delete(id);
        return ResultVO.success(null);
    }

    @PutMapping("/status/change")
    public ResultVO changePostStatus(@RequestBody BaseDTO baseDTO) {
        postService.changePostStatus(baseDTO);
        return ResultVO.success(null);
    }

}
