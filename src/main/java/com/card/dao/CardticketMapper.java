package com.card.dao;

import com.card.entity.Cardticket;
import org.springframework.stereotype.Repository;


public interface CardticketMapper {
    int deleteByPrimaryKey(Integer ticketId);

    int insert(Cardticket record);

    int insertSelective(Cardticket record);

    Cardticket selectByPrimaryKey(Integer ticketId);

    int updateByPrimaryKeySelective(Cardticket record);

    int updateByPrimaryKey(Cardticket record);
}