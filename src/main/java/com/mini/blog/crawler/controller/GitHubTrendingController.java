package com.mini.blog.crawler.controller;

import com.mini.blog.crawler.constant.UriConstant;
import com.mini.blog.crawler.model.Developer;
import com.mini.blog.crawler.service.GitHubTrendingService;
import com.mini.blog.crawler.utils.HttpUtil;
import com.mini.blog.model.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author kpq
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api/trending")
@Api(tags = "获取github trending")
@Slf4j
public class GitHubTrendingController {

    @Resource
    GitHubTrendingService gitHubTrendingService;

    @GetMapping(value = {"/{language}", "/"})
    @ApiOperation(value = "获取github trending流行仓库信息", notes = "获取github trending page api")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "language", value = "查询语言", dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "since", value = "查询日期", dataType = "String", paramType = "query")
    })
    public ResultVO getGitHubTrending(@PathVariable(required = false) String language, @RequestParam(value = "since", required = false) String since) {
        return ResultVO.success(gitHubTrendingService.getGitHubTrending(language, since));
    }

    @GetMapping("/developer")
    @ApiOperation(value = "获取github trending开发者信息")
    public ResultVO getDeveloper() {
        List<Developer> list = new ArrayList<>();
        try {
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
                            developer.setPopularRepoDescription(element2.text());
                        }
                        list.add(developer);
                    }
            );
        } catch (Exception e) {
            log.error("请求或者解析出错{}", e.getMessage());
        }
        return ResultVO.success(list);
    }
}
