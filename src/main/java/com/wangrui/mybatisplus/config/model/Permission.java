package com.wangrui.mybatisplus.config.model;

public class Permission {
    private Integer id;
    private String name;
    private String description;
    private String url;
    private Integer pid;

    public Permission() {
    }

    public Permission(Integer id, String name, String description, String url, Integer pid) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.pid = pid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

}
