package com.jfmlc.demo.common.utils;

import java.util.UUID;

/**
 * @author fumei
 * @data 2018-11-19 16:29
 */
public class UuidUtil {

    /**
     * 生成前缀+32位编码 用作id
     *
     * @return string
     */
    public static String genarateId(String prefix) {
        String uuid = prefix + UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }


    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}



