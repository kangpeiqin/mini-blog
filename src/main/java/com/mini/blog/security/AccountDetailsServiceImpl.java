package com.mini.blog.security;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mini.blog.beans.model.AccountDetails;
import com.mini.blog.entity.User;
import com.mini.blog.manager.UserManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author kpq
 * @since 1.0.0
 */
@Service
public class AccountDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserManager userManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userManager.getOne(Wrappers.lambdaQuery(User.class).eq(User::getUsername, username));
        if (user == null) {
            throw new UsernameNotFoundException("用户名或者密码错误");
        }
        return new AccountDetails(user);
    }
}
