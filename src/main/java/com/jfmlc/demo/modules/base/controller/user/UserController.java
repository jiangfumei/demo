package com.jfmlc.demo.modules.base.controller.user;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fumei
 * @data 2018-11-19 16:07
 */
@Slf4j
@RestController
@Api(value = "用户管理接口")
public class UserController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;


    public void add(){
        stringRedisTemplate.opsForValue();

    }
}
