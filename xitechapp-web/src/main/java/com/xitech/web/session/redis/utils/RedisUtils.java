package com.xitech.web.session.redis.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

//声明为spring组件
@Component
public class RedisUtils {

	// inject the actual template
    @Autowired
    private RedisTemplate<String, String> redisCache;
    
    
    
    
}
