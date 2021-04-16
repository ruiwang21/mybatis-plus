package com.wangrui.mybatisplus.mapper;


import com.wangrui.mybatisplus.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysUserMapper {
    SysUser selectUserByUsername(String username);
}
