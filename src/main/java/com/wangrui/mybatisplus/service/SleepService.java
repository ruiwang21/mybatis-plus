package com.wangrui.mybatisplus.service;

public interface SleepService {
    void syncSleep() throws InterruptedException;
    void asyncSleep() throws InterruptedException;
}
