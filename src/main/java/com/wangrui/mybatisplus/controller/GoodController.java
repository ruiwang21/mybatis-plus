package com.wangrui.mybatisplus.controller;

import com.wangrui.mybatisplus.redis.RedisUtil;
import com.wangrui.mybatisplus.model.SysUser;
import com.wangrui.mybatisplus.model.UserInfo;
import com.wangrui.mybatisplus.service.Impl.GoodsRedis;
import com.wangrui.mybatisplus.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;


@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/good")
public class GoodController {
    @Autowired
    UserInfoService userInfoService;

    @Autowired
    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("/addGood")
    private String addGood(){
        SysUser sysUser=new SysUser(1,"admin","admin");
        redisUtil.set("apple",sysUser.getUsername());
        return "success";
    };
    @GetMapping("/getKey")
    private Object getKey(@PathVariable("key") String key){
        Object str=redisUtil.get(key);
        return str;
    };

    @GetMapping("/getOne")
    public UserInfo getOneUser(@RequestParam Integer id){
        return userInfoService.selectByPrimaryKey(id);
    }


}
