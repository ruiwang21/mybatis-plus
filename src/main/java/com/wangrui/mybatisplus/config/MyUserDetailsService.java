package com.wangrui.mybatisplus.config;


import com.wangrui.mybatisplus.config.model.Permission;
import com.wangrui.mybatisplus.model.SysUser;
import com.wangrui.mybatisplus.service.PermissionService;
import com.wangrui.mybatisplus.service.SysUserService;
import com.wangrui.mybatisplus.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    SysUserService sysUserService;
    @Autowired
    PermissionService permissionService;
    private Logger logger=LoggerFactory.getLogger(MyUserDetailsService.class);
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("<<接收到用户名>>----"+username);

        SysUser sysUser=sysUserService.selectUserByUsername(username);
        if (sysUser==null){
            throw  new UsernameNotFoundException(username+"do not exist!");
        }
        List<Permission> permissionList=permissionService.findByAdminUserId(sysUser.getId());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Permission permission : permissionList) {
            if (permission != null && permission.getName()!=null) {

                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                grantedAuthorities.add(grantedAuthority);
            }
        }
        return new User(sysUser.getUsername(),
                new BCryptPasswordEncoder().encode(sysUser.getPassword()), grantedAuthorities);

    }
}
