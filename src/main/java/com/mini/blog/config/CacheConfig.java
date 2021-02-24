package com.mini.blog.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author kpq
 * @since 1.0.0
 */
@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .expireAfterAccess(120, TimeUnit.DAYS));
        return cacheManager;
    }

    @Bean("trendingCacheManager")
    public CacheManager trendingCacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCacheNames(Arrays.asList("github-cache", "trending"));
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .expireAfterAccess(24, TimeUnit.HOURS));
        return cacheManager;
    }

}
