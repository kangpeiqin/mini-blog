package com.mini.blog.common;

import com.mini.blog.handler.file.FileHandler;
import com.mini.blog.model.dto.StorageDTO;
import com.mini.blog.model.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;


/**
 * @author kpq
 * @since 1.0.0
 */
@RestController
@RequestMapping("/upload")
@Api(tags = "文件上传")
public class CommonController {

    @Resource
    FileHandler fileHandler;

    @PostMapping
    @ApiOperation(value = "file", notes = "文件上传", httpMethod = "POST")
    public ResultVO<StorageDTO> upload(@RequestParam(name = "file", required = false) MultipartFile file) {
        return ResultVO.success(fileHandler.upload(file));
    }

}
