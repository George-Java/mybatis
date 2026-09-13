package com.george.mybatisplus.service;

import com.george.mybatisplus.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void test() {
        List<User> users = userService.listByIds(Arrays.asList(1L, 2L, 3L));
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testLambdaQuery() {
        List<User> users = userService.queryUsers("J", 1, 1000, 3000);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testLambdaUpdate() {

    }
}