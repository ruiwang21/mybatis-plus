package com.wangrui.mybatisplus.controller;

import com.wangrui.mybatisplus.model.Cron;
import com.wangrui.mybatisplus.service.CronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/cron")
public class CronController {
    @Autowired
    @Resource
    CronService cronService;

    @GetMapping("/getCronList")
    public List<Cron> getCronList() {
        List<Cron> list=cronService.getCronList();
        return list;
    }
}
