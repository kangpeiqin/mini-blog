package com.mini.blog.utils;

import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;

/**
 * @author kpq
 * @since 1.0.0
 */
public class FileUtils {
    /**
     * 图片类型
     */
    static MediaType IMAGE_TYPE = MediaType.valueOf("image/*");

    /**
     * 判断是否为图片类型
     *
     * @param mediaType
     * @return
     */
    public static boolean isImageType(@Nullable String mediaType) {
        return mediaType != null && IMAGE_TYPE.includes(MediaType.valueOf(mediaType));
    }

}
