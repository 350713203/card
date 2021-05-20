package com.card.entity;

import java.util.Date;

public class Shops {
    private Integer shopsId;

    private Integer shopsCode;

    private String shopsName;

    private String shopsKind;

    private String shopsJifen;

    private String shopsStatus;

    private String shopsDescribe;

    private Date shopsCreateDate;

    private Date shopsUpdateDate;

    public Integer getShopsId() {
        return shopsId;
    }

    public void setShopsId(Integer shopsId) {
        this.shopsId = shopsId;
    }

    public Integer getShopsCode() {
        return shopsCode;
    }

    public void setShopsCode(Integer shopsCode) {
        this.shopsCode = shopsCode;
    }

    public String getShopsName() {
        return shopsName;
    }

    public void setShopsName(String shopsName) {
        this.shopsName = shopsName == null ? null : shopsName.trim();
    }

    public String getShopsKind() {
        return shopsKind;
    }

    public void setShopsKind(String shopsKind) {
        this.shopsKind = shopsKind == null ? null : shopsKind.trim();
    }

    public String getShopsJifen() {
        return shopsJifen;
    }

    public void setShopsJifen(String shopsJifen) {
        this.shopsJifen = shopsJifen == null ? null : shopsJifen.trim();
    }

    public String getShopsStatus() {
        return shopsStatus;
    }

    public void setShopsStatus(String shopsStatus) {
        this.shopsStatus = shopsStatus == null ? null : shopsStatus.trim();
    }

    public String getShopsDescribe() {
        return shopsDescribe;
    }

    public void setShopsDescribe(String shopsDescribe) {
        this.shopsDescribe = shopsDescribe == null ? null : shopsDescribe.trim();
    }

    public Date getShopsCreateDate() {
        return shopsCreateDate;
    }

    public void setShopsCreateDate(Date shopsCreateDate) {
        this.shopsCreateDate = shopsCreateDate;
    }

    public Date getShopsUpdateDate() {
        return shopsUpdateDate;
    }

    public void setShopsUpdateDate(Date shopsUpdateDate) {
        this.shopsUpdateDate = shopsUpdateDate;
    }
}