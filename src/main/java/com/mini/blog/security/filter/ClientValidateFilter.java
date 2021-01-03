package com.mini.blog.security.filter;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mini.blog.Constant.ClientConstants;
import com.mini.blog.beans.vo.ResultVO;
import com.mini.blog.entity.Client;
import com.mini.blog.manager.ClientManager;
import com.mini.blog.Constant.SecurityConstants;
import com.mini.blog.utils.ResponseUtils;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kpq
 * @since 1.0.0
 */
@Component
public class ClientValidateFilter extends OncePerRequestFilter {

    @Resource
    private ClientManager clientManager;

    @Resource
    private CacheManager cacheManager;

    @PostConstruct
    public void init(){
        Cache cache = cacheManager.getCache("appCache");
        List<Client> clients = clientManager.list(Wrappers.lambdaQuery(Client.class).eq(Client::getState, 1));
        cache.put(ClientConstants.CLIENTS, clients);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String clientId = request.getHeader(ClientConstants.CLIENT_ID);
        String clientSecret = request.getHeader(ClientConstants.CLIENT_SECRET);
        if (StringUtils.isEmpty(clientId) || StringUtils.isEmpty(clientSecret)) {
            ResponseUtils.jsonResponse(request, response, ResultVO.error(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase()));
            return;
        }
        Client client = getClient(clientId);
        if (client != null && client.getClientSecret().equals(clientSecret)) {
            filterChain.doFilter(request, response);
        } else {
            ResponseUtils.jsonResponse(request, response, ResultVO.error(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase()));
        }
    }

    /**
     * 获取客户端信息
     *
     * @param clientId
     * @return
     */
    private Client getClient(String clientId) {
        Cache cache = cacheManager.getCache("appCache");
        if (cache.get(ClientConstants.CLIENTS) == null) {
            List<Client> clients = clientManager.list(Wrappers.lambdaQuery(Client.class).eq(Client::getState, 1));
            cache.put(ClientConstants.CLIENTS, clients);
            return clients.stream().filter(e -> clientId.equals(e.getClientId())).collect(Collectors.toList()).get(0);
        } else {
            Client client = ((List<Client>) cache.get(ClientConstants.CLIENTS, List.class)).stream()
                    .filter(e -> clientId.equals(e.getClientId())).collect(Collectors.toList()).get(0);
            return client;
        }
    }

}
