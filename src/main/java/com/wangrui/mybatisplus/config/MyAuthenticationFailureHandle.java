package com.wangrui.mybatisplus.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyAuthenticationFailureHandle implements AuthenticationFailureHandler {
    private Logger logger= LoggerFactory.getLogger(MyAuthenticationFailureHandle.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        logger.info("用户名密码错误");
        JSONObject json = null;
        Map<String,String> map=new HashMap<>();
        map.put("msg","用户名密码错误！");
        map.put("type","0");
        json= (JSONObject) JSON.toJSON(map);
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        try (PrintWriter printWriter = httpServletResponse.getWriter()) {
            printWriter.append(json.toString());
        } catch (IOException i) {
            logger.error(i.getMessage(), i);
        }
    }
}
