package com.mini.blog.controller.content;

import com.mini.blog.model.vo.ResultVO;
import com.mini.blog.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author kpq
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/category")
@Api(tags = "文章分类")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping
    @ApiOperation("分类目录分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "当前页",dataType = "Long"),
            @ApiImplicitParam(name = "pageSize",value = "分页大小",dataType = "Long")
    })
    public ResultVO findPage(@RequestParam("pageNum") Long pageNum,@RequestParam(value = "pageSize",required = false,defaultValue = "10") Long pageSize) {
        return ResultVO.success(categoryService.findPage(pageNum,pageSize));
    }

    @GetMapping("/all")
    @ApiOperation("查找所有分类")
    public ResultVO findAll(){
        return ResultVO.success(categoryService.findAll());
    }

    @GetMapping("{categoryId:\\w+}")
    @ApiOperation("根据分类id获取所有文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "当前页",dataType = "Long"),
            @ApiImplicitParam(name = "pageSize",value = "分页大小",dataType = "Long"),
            @ApiImplicitParam(name = "categoryId",value = "分类id",dataType = "String")
    })
    public ResultVO listPostByCategoryId(@RequestParam("pageNum") Long pageNum,@RequestParam(value = "pageSize",required = false,defaultValue = "10") Long pageSize,@PathVariable("categoryId") String categoryId) {
        return ResultVO.success(categoryService.listPostByCategoryId(pageNum,pageSize,categoryId));
    }
}
