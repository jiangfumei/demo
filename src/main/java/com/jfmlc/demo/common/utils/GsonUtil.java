package com.jfmlc.demo.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author fumei
 * @date 2018-11-20 11:07
 */
public class GsonUtil {
        public static String toJson(Object obj) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            return gson.toJson(obj);
        }
}
