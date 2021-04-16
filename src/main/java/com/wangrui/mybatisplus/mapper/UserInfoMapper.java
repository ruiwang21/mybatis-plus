package com.wangrui.mybatisplus.mapper;


import com.wangrui.mybatisplus.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserInfoMapper {
    UserInfo selectByPrimaryKey(Integer id);
    UserInfo selectByUsername(String username);
}
