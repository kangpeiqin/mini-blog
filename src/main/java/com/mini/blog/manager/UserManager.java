package com.mini.blog.manager;

import com.mini.blog.entity.User;
import com.mini.blog.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  用户信息表 服务实现类
 * </p>
 *
 * @author generator
 * @since 2020-11-29
 */
@Service
public class UserManager extends ServiceImpl<UserMapper, User>  {

}
