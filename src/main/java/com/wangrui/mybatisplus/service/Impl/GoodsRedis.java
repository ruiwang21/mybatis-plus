package com.wangrui.mybatisplus.service.Impl;

import com.wangrui.mybatisplus.redis.RedisUtil;
import com.wangrui.mybatisplus.service.IGoodsRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

@Service
public class GoodsRedis implements IGoodsRedisService {
//    @Autowired
//    private RedisUtil redisUtil;
//
//    @Override
//    public void addGoodsString(String key, Object value)
//    {
//        redisUtil.StringSet(key, value);
//    }

//    @Override
//    public void addGoodsHash(String key, String item, Object value)
//    {
//        redisUtil.HashSet(key, item, value);
//    }
//
//    @Override
//    public Object getGoodsHash(String key, String item) {
//        return redisUtil.HashGet(key, item);
//    }
}
