package com.wangrui.mybatisplus.service.Impl;

import com.wangrui.mybatisplus.mapper.SysUserMapper;
import com.wangrui.mybatisplus.model.SysUser;
import com.wangrui.mybatisplus.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;
    @Override
    public SysUser selectUserByUsername(String username) {
        return sysUserMapper.selectUserByUsername(username);
    }
}
