package com.card.entity;

import java.util.Date;

public class Area {
    private Integer areaId;

    private Integer areaCode;

    private String areaName;

    private Integer areaStatus;

    private String areaDescribe;

    private Date areaCreateDate;

    private Date areaUpdateDate;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public Integer getAreaStatus() {
        return areaStatus;
    }

    public void setAreaStatus(Integer areaStatus) {
        this.areaStatus = areaStatus;
    }

    public String getAreaDescribe() {
        return areaDescribe;
    }

    public void setAreaDescribe(String areaDescribe) {
        this.areaDescribe = areaDescribe == null ? null : areaDescribe.trim();
    }

    public Date getAreaCreateDate() {
        return areaCreateDate;
    }

    public void setAreaCreateDate(Date areaCreateDate) {
        this.areaCreateDate = areaCreateDate;
    }

    public Date getAreaUpdateDate() {
        return areaUpdateDate;
    }

    public void setAreaUpdateDate(Date areaUpdateDate) {
        this.areaUpdateDate = areaUpdateDate;
    }
}