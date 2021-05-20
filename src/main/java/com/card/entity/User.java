package com.card.entity;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userTelphone;

    private String userEmai;

    private Integer userTotalCard;

    private Integer userTotalPos;

    private String userDescribe;

    private Date userCreateDate;

    private Date userUpdateDate;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserTelphone() {
        return userTelphone;
    }

    public void setUserTelphone(String userTelphone) {
        this.userTelphone = userTelphone == null ? null : userTelphone.trim();
    }

    public String getUserEmai() {
        return userEmai;
    }

    public void setUserEmai(String userEmai) {
        this.userEmai = userEmai == null ? null : userEmai.trim();
    }

    public Integer getUserTotalCard() {
        return userTotalCard;
    }

    public void setUserTotalCard(Integer userTotalCard) {
        this.userTotalCard = userTotalCard;
    }

    public Integer getUserTotalPos() {
        return userTotalPos;
    }

    public void setUserTotalPos(Integer userTotalPos) {
        this.userTotalPos = userTotalPos;
    }

    public String getUserDescribe() {
        return userDescribe;
    }

    public void setUserDescribe(String userDescribe) {
        this.userDescribe = userDescribe == null ? null : userDescribe.trim();
    }

    public Date getUserCreateDate() {
        return userCreateDate;
    }

    public void setUserCreateDate(Date userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    public Date getUserUpdateDate() {
        return userUpdateDate;
    }

    public void setUserUpdateDate(Date userUpdateDate) {
        this.userUpdateDate = userUpdateDate;
    }
}