package com.wangrui.mybatisplus.service;


import com.wangrui.mybatisplus.model.SysUser;

public interface SysUserService {
    SysUser selectUserByUsername(String username);
}
