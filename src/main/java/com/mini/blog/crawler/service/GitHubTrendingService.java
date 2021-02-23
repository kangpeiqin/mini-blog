package com.mini.blog.crawler.service;


import com.google.common.collect.Lists;
import com.mini.blog.crawler.constant.UriConstant;
import com.mini.blog.crawler.model.Developer;
import com.mini.blog.crawler.model.Repository;
import com.mini.blog.crawler.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    public List<Repository> getGitHubTrending(String language, String since) {
        Cache trendingCache = cacheManager.getCache("trending");
        List repositories = trendingCache.get("github_trending_" + language + '_' + since, List.class);
        if (!CollectionUtils.isEmpty(repositories)) {
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


    public List<Developer> getDevelopers() {
        List<Developer> list = Lists.newArrayList();
        try {
            Cache trendingCache = cacheManager.getCache("trending");
            List developerList = trendingCache.get("github_developers", List.class);
            if (!CollectionUtils.isEmpty(developerList)) {
                return developerList;
            }
            String html = HttpUtil.httpGet(UriConstant.GITHUB_TRENDING_URI + "developers", new HashMap<>(4));
            Document doc = Jsoup.parse(html);
            Elements articles = doc.getElementsByClass("Box-row d-flex");
            articles.forEach(article -> {
                        Developer developer = new Developer();
                        Element user = article.getElementsByClass("rounded-1 avatar-user").first();
                        developer.setAvatar(user.attr("src"));
                        Element element = article.getElementsByClass("h3 lh-condensed").first().getElementsByTag("a").first();
                        developer.setAuthor(element.text());
                        developer.setAccountLink(UriConstant.GITHUB_URI + element.attr("href"));
                        if (article.getElementsByClass("h4 lh-condensed").first() != null) {
                            Element element1 = article.getElementsByClass("h4 lh-condensed").first().getElementsByTag("a").first();
                            developer.setPopularRepoName(element1.text());
                            developer.setPopularRepoUrl(UriConstant.GITHUB_URI + element1.attr("href"));
                            Element element2 = article.getElementsByClass("f6 text-gray mt-1").first();
                            if (element2 != null) {
                                developer.setPopularRepoDescription(element2.text());
                            }
                        }
                        list.add(developer);
                    }
            );
            trendingCache.put("github_developers", list);
        } catch (Exception e) {
            log.error("请求或者解析出错{}", e.getMessage());
        }
        return list;
    }
}
