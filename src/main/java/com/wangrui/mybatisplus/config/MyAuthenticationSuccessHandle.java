package com.wangrui.mybatisplus.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyAuthenticationSuccessHandle implements AuthenticationSuccessHandler {
    private Logger logger= LoggerFactory.getLogger(MyAuthenticationSuccessHandle.class);
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        logger.info("登陆成功");
        JSONObject json = null;
        String username=httpServletRequest.getParameter("username");
        String password=httpServletRequest.getParameter("password");
        if (username!=null&&username.equals("admin")||username.equals("abel")){
            Map<String,String> map=new HashMap<>();
            map.put("msg","loginSuccess!");
            map.put("type","1");
            json= (JSONObject) JSON.toJSON(map);
        }
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter printWriter=null;
        try {
            printWriter=httpServletResponse.getWriter();
            printWriter.append(json.toString());
        }catch (IOException i){
            logger.error(i.getMessage(),i);
        }finally {
            if(printWriter!=null){
                printWriter.close();
            }
        }
    }
}
