package com.george.mybatisplus.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.george.mybatisplus.mapper"})
public class ApplicationConfig {
}
