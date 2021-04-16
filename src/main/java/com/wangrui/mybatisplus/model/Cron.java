package com.wangrui.mybatisplus.model;

public class Cron {
    private String cronId;
    private String cron;

    public String getCronId() {
        return cronId;
    }

    public void setCronId(String cronId) {
        this.cronId = cronId;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public Cron() {
    }

    public Cron(String cronId, String cron) {
        this.cronId = cronId;
        this.cron = cron;
    }

    @Override
    public String toString() {
        return "Cron{" +
                "cronId='" + cronId + '\'' +
                ", cron='" + cron + '\'' +
                '}';
    }
}
