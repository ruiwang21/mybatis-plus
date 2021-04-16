package com.wangrui.mybatisplus.config;


import com.wangrui.mybatisplus.util.JwtUtils;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JwtAuthenticationFilter extends BasicAuthenticationFilter {
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token=request.getHeader("token");
        //请求头中未携带token 直接放行
        if (token==null){
            chain.doFilter(request,response);
            return;
        }
        //请求头中携带token 解析请求头 ，获取用户权限
        logger.info(token);
        UsernamePasswordAuthenticationToken authenticationToken=getAuthentication(token);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request,response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token){

        try {
            String userName= JwtUtils.getUserName(token);
            logger.info(userName+"coming in");
            List<SimpleGrantedAuthority> simpleGrantedAuthorities=new ArrayList<>();
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            if(userName!=null){
                return new UsernamePasswordAuthenticationToken(userName,null,simpleGrantedAuthorities);
            }
        }catch (ExpiredJwtException e)
        {
            logger.error(e.getMessage());
            return null;
        }
        return null;
    }
}
