package com.qintin.web_common.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @name:
 * @description
 * @author: 苏敏
 * @create: 2023-05-10 18:07
 **/
public class JSONHandle {

    public static String toJsonString(Object o){
        return JSON.toJSONString(o);
    }
    public static <T> List<T> parserList(String jsonStr,Class<T> clazz){
        List<T> list = JSON.parseArray(jsonStr, clazz);
        return list;
    }
    public static <T> T parserObject(String jsonStr,Class<T> clazz){
        T object = JSON.parseObject(jsonStr, clazz);
        return object;
    }

    public static JSONObject parserJsonObject(String jsonStr){
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        return jsonObject;
    }
    /**
     *
     * @param jsonStr
     * @param clazz 例如，int[].class
     * @param <T>
     * @return
     */
    public static <T> T parserArray(String jsonStr,Class<T> clazz){
        T object = JSON.parseObject(jsonStr, clazz);
        return object;
    }
}
