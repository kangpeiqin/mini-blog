package com.mini.blog.handler.file;

import cn.hutool.core.util.IdUtil;
import com.mini.blog.model.StorageProperties;
import com.mini.blog.model.dto.StorageDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;


/**
 * 文件上传
 *
 * @author kpq
 * @since 1.0.0
 */
@Component
@Slf4j
public class FileHandler {

    @Resource
    private StorageProperties storageProperties;

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @NonNull
    public StorageDTO upload(@NonNull MultipartFile file) {
        String filename = file.getOriginalFilename();
        if (StringUtils.isNotBlank(filename)) {
            int index = filename.lastIndexOf(".");
            //获取文件后缀名
            String suffix = filename.substring(index);
            String key = IdUtil.fastUUID() + suffix;
            String filePath = storageProperties.getLocation() + key;
            Path uploadPath = Paths.get(filePath);
            try {
                //创建上级目录
                Files.createDirectories(uploadPath.getParent());
                //创建空文件
                Files.createFile(uploadPath);
                //文件拷贝
                file.transferTo(uploadPath);
                return StorageDTO.builder().filename(filename).key(key).url(storageProperties.getAddress() + key).build();
            } catch (Exception e) {
                log.error("上传文件错误{}", e.getMessage());
            }
        }
        return null;
    }


}
