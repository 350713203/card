package com.card.dao;

import com.card.entity.Card_bank;

public interface Card_bankMapper {
    int deleteByPrimaryKey(Integer cardId);

    int insert(Card_bank record);

    int insertSelective(Card_bank record);

    Card_bank selectByPrimaryKey(Integer cardId);

    int updateByPrimaryKeySelective(Card_bank record);

    int updateByPrimaryKey(Card_bank record);
}