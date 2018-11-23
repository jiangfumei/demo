package com.jfmlc.demo.config.audit;

import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author fumei
 * @date 2018-11-23 11:23
 * @description 在异步方法中获取用户信息
 */
@Configuration
public class AuditorAwareConfig {

    /**
     * SecurityContextHolder的主要功能是将当前执行的进程和SecurityContext关联起来。
     * SecurityContextHolder.MODE_INHERITABLETHREADLOCAL：用于线程有父子关系的情景中，子线程继承父线程的SecurityContextHolder；
     * SecurityContextHolder.MODE_INHERITABLETHREADLOCAL：全局共用SecurityContextHolder。
     */
    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean() {
        MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
        methodInvokingFactoryBean.setTargetClass(SecurityContextHolder.class);
        methodInvokingFactoryBean.setTargetMethod("setStrategyName");
        methodInvokingFactoryBean.setArguments(new String[]{SecurityContextHolder.MODE_INHERITABLETHREADLOCAL});
        return methodInvokingFactoryBean;
    }

}
