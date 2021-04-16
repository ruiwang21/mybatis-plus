package com.wangrui.mybatisplus.service.Impl;

import com.wangrui.mybatisplus.mapper.CronMapper;
import com.wangrui.mybatisplus.model.Cron;
import com.wangrui.mybatisplus.service.CronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CronServiceImpl implements CronService {
    @Autowired
    CronMapper cronMapper;
    @Override
    public List<Cron> getCronList() {
        return cronMapper.getCronList();
    }
}
