package com.wangrui.mybatisplus.mapper;

import com.wangrui.mybatisplus.config.model.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PermissionMapper {
     List<Permission> findByAdminUserId(Integer userId);
}
