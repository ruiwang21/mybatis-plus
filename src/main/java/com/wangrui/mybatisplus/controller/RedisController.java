package com.wangrui.mybatisplus.controller;




import com.wangrui.mybatisplus.model.UserInfo;
import com.wangrui.mybatisplus.redis.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@Api("redis测试服务")
@RequestMapping("/redis")
@RestController
public class RedisController {

    private static int ExpireTime = 60;   // redis中存储的过期时间60s

    @Resource
    private RedisUtil redisUtil;

    @ApiOperation("创建redis存储数据")
    @RequestMapping("/set")
    public boolean redisSet(@RequestParam String key, @RequestParam String value){
        UserInfo userInfo=new UserInfo();
        userInfo.setId(1);
        userInfo.setName("王芮");
        userInfo.setAge("25");

        //return redisUtil.set(key,userEntity,ExpireTime);
        return redisUtil.set(key,value);
    }

    @RequestMapping("/get")
    public Object redisget(@RequestParam("key") String key){
        return redisUtil.get(key);
    }

    @RequestMapping("/expire")
    public boolean expire(String key){
        return redisUtil.expire(key,ExpireTime);
    }

    @GetMapping("/getMsg")
    public String getString(){
        String message="this is test";
        return message;
    }

}

