package com.mini.blog.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 文件上传配置类
 * @author kpq
 * @since 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "storage")
@Data
public class StorageProperties {

    private String address;

    private String location;

    private String uriPrefix;

}
