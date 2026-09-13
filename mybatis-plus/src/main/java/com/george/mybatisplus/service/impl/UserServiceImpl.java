package com.george.mybatisplus.service.impl;

import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.george.mybatisplus.domain.entity.User;
import com.george.mybatisplus.mapper.UserMapper;
import com.george.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public List<User> queryUsers(String name, Integer status, Integer minBalance, Integer maxBalance) {
        return lambdaQuery()
                .like(name != null, User::getUsername, name)
                .eq(status != null, User::getStatus, status)
                .between(minBalance != null && maxBalance != null, User::getBalance, minBalance, maxBalance)
                .list();
    }
}
