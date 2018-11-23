package com.jfmlc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author fumei
 * @date 2018-11-16 14:00
 */
@SpringBootApplication
@EnableCaching //启动缓存
@EnableJpaAuditing //启用审计
@EnableAsync //启用异步
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}



