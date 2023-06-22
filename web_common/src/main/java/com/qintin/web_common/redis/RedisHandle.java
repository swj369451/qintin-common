package com.qintin.web_common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @name:
 * @description
 * @author: 苏敏
 * @create: 2023-06-17 19:45
 **/
public class RedisHandle {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void setData(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String getData(String key) {
        return redisTemplate.opsForValue().get(key);
    }

}
