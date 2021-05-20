package com.card.dao;

import com.card.entity.Shops;

public interface ShopsMapper {
    int deleteByPrimaryKey(Integer shopsId);

    int insert(Shops record);

    int insertSelective(Shops record);

    Shops selectByPrimaryKey(Integer shopsId);

    int updateByPrimaryKeySelective(Shops record);

    int updateByPrimaryKey(Shops record);
}