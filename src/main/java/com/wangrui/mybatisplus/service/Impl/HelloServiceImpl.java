package com.wangrui.mybatisplus.service.Impl;

import com.wangrui.mybatisplus.service.HelloService;
import com.wangrui.mybatisplus.service.SleepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    private SleepService sleepService;
    @Override
    public String synchSayHello() {
        try {
            sleepService.syncSleep();
            return "hello world,这是同步方法";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "error";
        }
    }

    @Override
    public String asynchSayHello() {
        try {
            System.out.println("主线程 "+Thread.currentThread().getName());
            sleepService.asyncSleep();
            return "hello world,这是异步方法";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "error";
        }
    }
}
