package com.wangrui.mybatisplus.service.Impl;


import com.wangrui.mybatisplus.config.model.Permission;
import com.wangrui.mybatisplus.mapper.PermissionMapper;
import com.wangrui.mybatisplus.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> findByAdminUserId(Integer userId) {
        return permissionMapper.findByAdminUserId(userId);
    }
}
