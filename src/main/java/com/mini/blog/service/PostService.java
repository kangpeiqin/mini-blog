package com.mini.blog.service;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.mini.blog.entity.Post;
import com.mini.blog.entity.PostTag;
import com.mini.blog.manager.PostManager;
import com.mini.blog.manager.PostTagManager;
import com.mini.blog.model.dto.PostDTO;
import com.mini.blog.model.dto.YearPostDTO;
import com.mini.blog.model.vo.ArchiveVO;
import com.mini.blog.model.vo.PostListVO;
import com.mini.blog.mapper.PostMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author kpq
 * @since 1.0.0
 */
@Service
public class PostService {

    @Resource
    private PostMapper postMapper;

    @Resource
    private PostManager postManager;

    @Resource
    private PostTagManager postTagManager;

    /**
     * 文章展示分页
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public IPage<PostListVO> findPage(Long pageNum, Long pageSize, String keyWord) {
        return postMapper.findPage(new Page<>(pageNum, pageSize), keyWord);
    }

    public Post getById(String id) {
        return postManager.getById(id);
    }

    /**
     * 创建文章
     *
     * @param postDTO
     */
    @Transactional(rollbackFor = Exception.class)
    public void insert(PostDTO postDTO) {
        List<PostTag> postTagList = Lists.newArrayList();
        postDTO.getTagIds().forEach(e -> {
            PostTag postTag = new PostTag();
            postTag.setPostId(postDTO.getId());
            postTag.setTagId(e);
            postTagList.add(postTag);
        });
        postTagManager.saveBatch(postTagList);
        postManager.save(postDTO);
    }

    /**
     * 更新文章
     *
     * @param postDTO
     */
    @Transactional(rollbackFor = Exception.class)
    public void update(PostDTO postDTO) {
        postTagManager.remove(new LambdaQueryWrapper<PostTag>().eq(PostTag::getPostId, postDTO.getId()));
        this.insert(postDTO);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(String[] ids) {
        List<String> postIdList = Arrays.asList(ids);
        Assert.notNull(postIdList);
        postManager.removeByIds(postIdList);
        Wrapper<PostTag> queryWrapper = new LambdaQueryWrapper<PostTag>().in(PostTag::getPostId, postIdList);
        List<PostTag> list = postTagManager.list(queryWrapper);
        Set<String> postTagIdSet = list.stream().map(PostTag::getPostId).collect(Collectors.toSet());
        postTagManager.removeByIds(postTagIdSet);
    }

    public ArchiveVO getArchive(Long pageNum, Long pageSize) {
        List<YearPostDTO> yearPostList = Lists.newArrayList();
        IPage<Post> page = postMapper.listByPage(new Page<>(pageNum, pageSize));
        List<Post> postList = page.getRecords();
        Map<Integer, List<Post>> yearPostMap = postList.stream().collect(Collectors.groupingBy(e -> e.getPostYear(e.getCreateTime())));
        yearPostMap.forEach((k, v) -> {
            YearPostDTO postDTO = YearPostDTO.builder().year(k).posts(v).build();
            yearPostList.add(postDTO);
        });
        yearPostList.sort(Comparator.comparing(YearPostDTO::getYear).reversed());
        ArchiveVO archive = ArchiveVO.builder().total(page.getTotal()).list(yearPostList).build();
        return archive;
    }

}
