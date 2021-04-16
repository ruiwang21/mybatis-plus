package com.wangrui.mybatisplus.service;
import com.wangrui.mybatisplus.config.model.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findByAdminUserId(Integer userId);
}
