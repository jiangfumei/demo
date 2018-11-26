package com.jfmlc.demo.modules.base.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author fumei
 * @data 2018-11-19 16:07
 */
@Api(value = "用户管理")
public class UserController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;


    public void add(){
        stringRedisTemplate.opsForValue();

    }
}
