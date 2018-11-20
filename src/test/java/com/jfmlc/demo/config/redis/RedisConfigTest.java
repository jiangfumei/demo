package com.jfmlc.demo.config.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author fumei
 * @date 2018-11-20 16:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisConfigTest {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void stringTest(){
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("hello", "redis");
        System.out.println("useRedisDao = " + valueOperations.get("hello"));
    }


}
