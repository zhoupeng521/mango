package com.zp.mango.model;

import com.zp.mango.common.base.BaseModel;

public class SysMenu extends BaseModel {

    private String name;

    private Long parentId;

    private String url;

    private String perms;

    private String icom;

    private Integer orderNum;

    private Byte delFlag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms == null ? null : perms.trim();
    }

    public String getIcom() {
        return icom;
    }

    public void setIcom(String icom) {
        this.icom = icom == null ? null : icom.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }
}