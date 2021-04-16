package com.wangrui.mybatisplus.service;


import com.wangrui.mybatisplus.model.UserInfo;

public interface UserInfoService {
    UserInfo selectByPrimaryKey(Integer id);

    UserInfo selectByUsername(String username);
}
