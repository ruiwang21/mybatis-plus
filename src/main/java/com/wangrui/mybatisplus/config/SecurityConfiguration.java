package com.wangrui.mybatisplus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    MyAuthenticationSuccessHandle myAuthenticationSuccessHandle;

    @Autowired
    MyAuthenticationFailureHandle myAuthenticationFailureHandle;
    @Autowired
    UnAuthenticationEntryPoint unAuthenticationEntryPoint;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService)
                .passwordEncoder(passwordEncoder());//passwoldEncoder是对密码的加密处理，如果user中密码没有加密，则可以不加此方法。注意加密请使用security自带的加密方式。
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()//禁用了 csrf 功能
                .authorizeRequests()//限定签名成功的请求
                .antMatchers("/login").permitAll()
                .antMatchers("/index","/getLoginKey").permitAll()//开放接口获取token
                .antMatchers("/employee/*").permitAll()//对decision和govern 下的接口 需要 USER 或者 ADMIN 权限
                .antMatchers("/admin/**").hasRole("ADMIN")//对admin下的接口 需要ADMIN权限
                .anyRequest().authenticated()//其他所有请求都需要认证
                .and().httpBasic().authenticationEntryPoint(unAuthenticationEntryPoint) //请求接口未授权返回结果
                .and().addFilter(new JwtAuthenticationFilter(authenticationManager())) //访问接口url需要权限的时候进入这个拦截器 权限拦截器
                .anonymous()
                .and().formLogin().successHandler(myAuthenticationSuccessHandle)
                .failureHandler(myAuthenticationFailureHandle);//使用 spring security 默认登录页面
    }
}
