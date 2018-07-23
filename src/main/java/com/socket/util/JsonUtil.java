package com.socket.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * create by WSL_SILVA
 * 日期: 2018/7/23 0023
 * 用途：
 * 描述:
 */
public class JsonUtil {

    public static String toJson(Object object){
        GsonBuilder gsonBuilder =  new GsonBuilder();
//        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
