package com.card.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Pos {
    private Integer posId;

    private Integer userId;

    private String posKindId;

    private String posName;

    private String posTotalName;

    private BigDecimal posStandardPay;

    private BigDecimal posFlashPay;

    private BigDecimal posIfadd3;

    private String posBank;

    private String posStatus;

    private String posDescribe;

    private Date posCreateDate;

    private Date posUpdateDate;

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPosKindId() {
        return posKindId;
    }

    public void setPosKindId(String posKindId) {
        this.posKindId = posKindId == null ? null : posKindId.trim();
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName == null ? null : posName.trim();
    }

    public String getPosTotalName() {
        return posTotalName;
    }

    public void setPosTotalName(String posTotalName) {
        this.posTotalName = posTotalName == null ? null : posTotalName.trim();
    }

    public BigDecimal getPosStandardPay() {
        return posStandardPay;
    }

    public void setPosStandardPay(BigDecimal posStandardPay) {
        this.posStandardPay = posStandardPay;
    }

    public BigDecimal getPosFlashPay() {
        return posFlashPay;
    }

    public void setPosFlashPay(BigDecimal posFlashPay) {
        this.posFlashPay = posFlashPay;
    }

    public BigDecimal getPosIfadd3() {
        return posIfadd3;
    }

    public void setPosIfadd3(BigDecimal posIfadd3) {
        this.posIfadd3 = posIfadd3;
    }

    public String getPosBank() {
        return posBank;
    }

    public void setPosBank(String posBank) {
        this.posBank = posBank == null ? null : posBank.trim();
    }

    public String getPosStatus() {
        return posStatus;
    }

    public void setPosStatus(String posStatus) {
        this.posStatus = posStatus == null ? null : posStatus.trim();
    }

    public String getPosDescribe() {
        return posDescribe;
    }

    public void setPosDescribe(String posDescribe) {
        this.posDescribe = posDescribe == null ? null : posDescribe.trim();
    }

    public Date getPosCreateDate() {
        return posCreateDate;
    }

    public void setPosCreateDate(Date posCreateDate) {
        this.posCreateDate = posCreateDate;
    }

    public Date getPosUpdateDate() {
        return posUpdateDate;
    }

    public void setPosUpdateDate(Date posUpdateDate) {
        this.posUpdateDate = posUpdateDate;
    }
}