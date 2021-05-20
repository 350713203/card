package com.card.entity;

import java.util.Date;

public class Card_bank {
    private Integer cardId;

    private Integer userId;

    private String cardName;

    private String cardTotalName;

    private String cardNumber;

    private Date cardEndDay;

    private String cardKind;

    private String cardColor;

    private String cardYear;

    private String cardStatus;

    private String cardDescribe;

    private Date cardCreateDate;

    private Date cardUpdateDate;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName == null ? null : cardName.trim();
    }

    public String getCardTotalName() {
        return cardTotalName;
    }

    public void setCardTotalName(String cardTotalName) {
        this.cardTotalName = cardTotalName == null ? null : cardTotalName.trim();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    public Date getCardEndDay() {
        return cardEndDay;
    }

    public void setCardEndDay(Date cardEndDay) {
        this.cardEndDay = cardEndDay;
    }

    public String getCardKind() {
        return cardKind;
    }

    public void setCardKind(String cardKind) {
        this.cardKind = cardKind == null ? null : cardKind.trim();
    }

    public String getCardColor() {
        return cardColor;
    }

    public void setCardColor(String cardColor) {
        this.cardColor = cardColor == null ? null : cardColor.trim();
    }

    public String getCardYear() {
        return cardYear;
    }

    public void setCardYear(String cardYear) {
        this.cardYear = cardYear == null ? null : cardYear.trim();
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus == null ? null : cardStatus.trim();
    }

    public String getCardDescribe() {
        return cardDescribe;
    }

    public void setCardDescribe(String cardDescribe) {
        this.cardDescribe = cardDescribe == null ? null : cardDescribe.trim();
    }

    public Date getCardCreateDate() {
        return cardCreateDate;
    }

    public void setCardCreateDate(Date cardCreateDate) {
        this.cardCreateDate = cardCreateDate;
    }

    public Date getCardUpdateDate() {
        return cardUpdateDate;
    }

    public void setCardUpdateDate(Date cardUpdateDate) {
        this.cardUpdateDate = cardUpdateDate;
    }
}