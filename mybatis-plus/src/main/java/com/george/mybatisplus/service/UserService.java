package com.george.mybatisplus.service;

import com.baomidou.mybatisplus.spring.service.IService;
import com.george.mybatisplus.domain.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> queryUsers(String name, Integer status, Integer minBalance, Integer maxBalance);
}
