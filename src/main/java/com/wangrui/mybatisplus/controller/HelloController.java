package com.wangrui.mybatisplus.controller;

import com.wangrui.mybatisplus.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("hello")
public class HelloController {
    @Autowired
    private HelloService helloService;

    /**
     * 异步方法
     * @return
     */
    @GetMapping("/asyn")
    public String getAsynHello(){
        long n = Instant.now().toEpochMilli();
        //异步
        String s = helloService.asynchSayHello();

        long f = Instant.now().toEpochMilli();
        return s + " 时间: " + (f-n);

    }

    /**
     * 同步方法
     * * @return
     */
    @GetMapping("/sync")
    public String getSyncHello(){

        long n = Instant.now().toEpochMilli();
        //异步
        String s = helloService.synchSayHello();

        long f = Instant.now().toEpochMilli();
        return s + " 时间: " + (f-n);
    }
}
