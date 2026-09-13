package com.george.mybatisplus.controller;

import cn.hutool.core.bean.BeanUtil;
import com.george.mybatisplus.domain.dto.UserFormDTO;
import com.george.mybatisplus.domain.entity.User;
import com.george.mybatisplus.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/")
    public String addUser(@RequestBody UserFormDTO user) {
        userService.save(BeanUtil.copyProperties(user, User.class));
        return "success";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @GetMapping("/")
    public List<User> getUsers() {
        return userService.list();
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.removeById(id);
        return "success";
    }

    @PutMapping("/{id}/update/{balance}")
    public String updateUser(@PathVariable Integer id, @PathVariable Integer balance) {
        userService.lambdaUpdate()
                .set(userService.getById(id).getBalance() >= balance, User::getBalance, balance)
                .eq(User::getId, id)
                .update();
        return "success";
    }
}
