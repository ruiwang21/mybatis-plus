package com.wangrui.mybatisplus.controller;


import com.wangrui.mybatisplus.model.UserInfo;
import com.wangrui.mybatisplus.service.UserInfoService;
import com.wangrui.mybatisplus.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController {
    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/getOne")
    public UserInfo getOneUser(@RequestParam Integer id){
        return userInfoService.selectByPrimaryKey(id);
    }

    @GetMapping("/test")
    public String userLogin(){
        return "test";
    }
    @GetMapping("/getLoginKey")
    public Map<String,String> getLoginKey(@RequestParam("userName") String userName, @RequestParam("password") String password){
        Map<String, String> map = new HashMap<>();
        if (userName != null && userName.length() > 0) {
            String token = JwtUtils.createJwt(userName, true);
            map.put("token",token);
        }else {
            map.put("msg","用户名和密码为空");
        }
        map.put("code", "200");
        return map;
    }
}
