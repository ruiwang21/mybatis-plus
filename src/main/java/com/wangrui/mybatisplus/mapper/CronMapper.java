package com.wangrui.mybatisplus.mapper;

import com.wangrui.mybatisplus.model.Cron;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface CronMapper {
    List<Cron> getCronList();
}
