package com.wangrui.mybatisplus.service.Impl;


import com.wangrui.mybatisplus.mapper.UserInfoMapper;
import com.wangrui.mybatisplus.model.UserInfo;
import com.wangrui.mybatisplus.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Override
    @Cacheable(value = "userInfo" ,key = "targetClass + methodName +#p0")
    public UserInfo selectByPrimaryKey(Integer id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserInfo selectByUsername(String username) {
        return userInfoMapper.selectByUsername(username);
    }
}
