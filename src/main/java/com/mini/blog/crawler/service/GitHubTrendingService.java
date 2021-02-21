package com.mini.blog.crawler.service;


import com.mini.blog.crawler.constant.UriConstant;
import com.mini.blog.crawler.model.Repository;
import com.mini.blog.crawler.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kpq
 * @since 1.0.0
 */
@Service
@Slf4j
public class GitHubTrendingService {

    @Resource
    private GitHubTrendingParser parser;

    @Resource(name = "trendingCacheManager")
    private CacheManager cacheManager;

    public  List<Repository> getGitHubTrending(String language, String since) {
        Cache trendingCache = cacheManager.getCache("trending");
        List repositories = trendingCache.get("github_trending_" + language + '_' + since, List.class);
        if (repositories != null) {
            return repositories;
        }
        String uri = UriConstant.GITHUB_TRENDING_URI;
        Map<String, String> paramMap = new HashMap<>(4);
        if (!StringUtils.isEmpty(language)) {
            uri += language;
        }
        if (!StringUtils.isEmpty(since)) {
            paramMap.put("since", since);
        }
        try {
            String html = HttpUtil.httpGet(uri, paramMap);
            List<Repository> repositoryList = parser.getTrendingRepositories(html);
            log.info("成功请求到数据：{}", repositoryList);
            trendingCache.put("github_trending_" + language + "_" + since, repositoryList);
            return repositoryList;
        } catch (Exception e) {
            log.error("error{}", e.getMessage());
        }
        return null;
    }
}
