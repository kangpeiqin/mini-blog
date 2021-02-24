package com.mini.blog.crawler.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 定时抓取
 *
 * @author kpq
 * @since 1.0.0
 */
@Slf4j
@Component
public class CrawlerOnTimeService {

    private List<String> languageList = Arrays.asList(null, "java", "python", "go", "c++", "c", "javascript");

    private List<String> sinceList = Arrays.asList("daily", "monthly", "weekly");

    @Resource
    private GitHubTrendingService gitHubTrendingService;

    @Resource(name = "trendingCacheManager")
    private CacheManager cacheManager;

    @Scheduled(fixedRate = 3600000)
//    @Scheduled(cron = "0 0 6,9,18,20 * * ? ")
    @Async("taskExecutor")
    public void fetchOnTime() {
        Cache trendingCache = cacheManager.getCache("trending");
        if (trendingCache != null) {
            trendingCache.clear();
        }
        languageList.forEach(l -> sinceList.forEach(s -> gitHubTrendingService.getGitHubTrending(l, s)));
        gitHubTrendingService.getDevelopers();
    }
}
