package com.jfmlc.demo.common.annotation;

import com.jfmlc.demo.common.enums.LogType;

import java.lang.annotation.*;

/**
 * 系统日志自定义注解
 * @author fumei
 * @date 2018-12-06 16:37
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})//作用于参数或方法上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {

    /**
     * 日志名称
     * @return
     */
    String description() default "";

    /**
     * 日志类型
     * @return
     */
    LogType type() default LogType.OPERATION;
}
