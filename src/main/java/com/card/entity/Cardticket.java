package com.card.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name="ticket")
public class Cardticket {
    @Id//定义主键
    //定义主键自增
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer ticketId;

    private Integer userId;

    private Date ticketTime;

    private String ticketBank;

    private String ticketPos;

    private String ticketShopsName;

    private String ticketPlaceName;

    private String ticketIsticket;

    private Integer ticketPosKind;

    private BigDecimal ticketAmount;

    private BigDecimal ticketRateMoney;

    private BigDecimal ticketAddMoney;

    private BigDecimal ticketActualMoney;

    private String ticketDescribe;

    private Date ticketCreateDate;

    private Date ticketUpdateDate;

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getTicketTime() {
        return ticketTime;
    }

    public void setTicketTime(Date ticketTime) {
        this.ticketTime = ticketTime;
    }

    public String getTicketBank() {
        return ticketBank;
    }

    public void setTicketBank(String ticketBank) {
        this.ticketBank = ticketBank == null ? null : ticketBank.trim();
    }

    public String getTicketPos() {
        return ticketPos;
    }

    public void setTicketPos(String ticketPos) {
        this.ticketPos = ticketPos == null ? null : ticketPos.trim();
    }

    public String getTicketShopsName() {
        return ticketShopsName;
    }

    public void setTicketShopsName(String ticketShopsName) {
        this.ticketShopsName = ticketShopsName == null ? null : ticketShopsName.trim();
    }

    public String getTicketPlaceName() {
        return ticketPlaceName;
    }

    public void setTicketPlaceName(String ticketPlaceName) {
        this.ticketPlaceName = ticketPlaceName == null ? null : ticketPlaceName.trim();
    }

    public String getTicketIsticket() {
        return ticketIsticket;
    }

    public void setTicketIsticket(String ticketIsticket) {
        this.ticketIsticket = ticketIsticket == null ? null : ticketIsticket.trim();
    }

    public Integer getTicketPosKind() {
        return ticketPosKind;
    }

    public void setTicketPosKind(Integer ticketPosKind) {
        this.ticketPosKind = ticketPosKind;
    }

    public BigDecimal getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(BigDecimal ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public BigDecimal getTicketRateMoney() {
        return ticketRateMoney;
    }

    public void setTicketRateMoney(BigDecimal ticketRateMoney) {
        this.ticketRateMoney = ticketRateMoney;
    }

    public BigDecimal getTicketAddMoney() {
        return ticketAddMoney;
    }

    public void setTicketAddMoney(BigDecimal ticketAddMoney) {
        this.ticketAddMoney = ticketAddMoney;
    }

    public BigDecimal getTicketActualMoney() {
        return ticketActualMoney;
    }

    public void setTicketActualMoney(BigDecimal ticketActualMoney) {
        this.ticketActualMoney = ticketActualMoney;
    }

    public String getTicketDescribe() {
        return ticketDescribe;
    }

    public void setTicketDescribe(String ticketDescribe) {
        this.ticketDescribe = ticketDescribe == null ? null : ticketDescribe.trim();
    }

    public Date getTicketCreateDate() {
        return ticketCreateDate;
    }

    public void setTicketCreateDate(Date ticketCreateDate) {
        this.ticketCreateDate = ticketCreateDate;
    }

    public Date getTicketUpdateDate() {
        return ticketUpdateDate;
    }

    public void setTicketUpdateDate(Date ticketUpdateDate) {
        this.ticketUpdateDate = ticketUpdateDate;
    }

    @Override
    public String toString() {
        return "Cardticket{" +
                "ticketId=" + ticketId +
                ", userId=" + userId +
                ", ticketTime=" + ticketTime +
                ", ticketBank='" + ticketBank + '\'' +
                ", ticketPos='" + ticketPos + '\'' +
                ", ticketShopsName='" + ticketShopsName + '\'' +
                ", ticketPlaceName='" + ticketPlaceName + '\'' +
                ", ticketIsticket='" + ticketIsticket + '\'' +
                ", ticketPosKind=" + ticketPosKind +
                ", ticketAmount=" + ticketAmount +
                ", ticketRateMoney=" + ticketRateMoney +
                ", ticketAddMoney=" + ticketAddMoney +
                ", ticketActualMoney=" + ticketActualMoney +
                ", ticketDescribe='" + ticketDescribe + '\'' +
                ", ticketCreateDate=" + ticketCreateDate +
                ", ticketUpdateDate=" + ticketUpdateDate +
                '}';
    }
}