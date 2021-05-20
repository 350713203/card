package com.card.dao;

import com.card.entity.Pos;

public interface PosMapper {
    int deleteByPrimaryKey(Integer posId);

    int insert(Pos record);

    int insertSelective(Pos record);

    Pos selectByPrimaryKey(Integer posId);

    int updateByPrimaryKeySelective(Pos record);

    int updateByPrimaryKey(Pos record);
}