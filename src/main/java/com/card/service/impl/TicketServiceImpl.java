package com.card.service.impl;

import com.card.dao.CardticketMapper;
import com.card.entity.Cardticket;
import com.card.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    private CardticketMapper cardticketMapper;

    @Override
    public void insert(Cardticket cardticket) {

        cardticket.setTicketCreateDate(new Date());
        cardticket.setTicketUpdateDate(new Date());
        cardticketMapper.insertSelective(cardticket);
        System.out.println("TicketServiceImpl中的:" + cardticket);
    }

    public static void main(String[] args) {
        BigDecimal bigDecimal=new BigDecimal("2.59248494");
        System.out.println(bigDecimal.getClass());
        System.out.println(Double.valueOf(bigDecimal.toString()).getClass());
        double b=bigDecimal.doubleValue();
        System.out.println(b);
//        1 BigDecimal big = new BigDecimal("2.3513"); //设置BigDecimal初始值
//        2 big.setScale(1);  // 保留1位小数，默认用四舍五入。
//        3 big.setScale(1, BigDecimal.ROUND_DOWN);  // 直接删除多余的小数，2.3513直接被截断位2.3
//        4 big.setScale(1, BigDecimal.ROUND_HALE_UP);  //四舍五入，向上舍入，2.3513变成2.4
//        5 big.setScale(1, BigDecimal.ROUND_HALF_DOWN);  //四舍五入，向下舍入，2.3513变成2.3
        BigDecimal bigDecimal1 = bigDecimal.setScale(4,BigDecimal.ROUND_HALF_DOWN);
        System.out.println(bigDecimal1);

        if(!(bigDecimal.compareTo(bigDecimal1)==0)){
            System.out.println("不相等");
        }

        BigDecimal b3=new BigDecimal("10");
        BigDecimal b4=new BigDecimal("5");

        double add = b3.add(b4).doubleValue();
        System.out.println(add);

        System.out.println(b4.subtract(b3));
        System.out.println(b3.multiply(b4));
        System.out.println(b4.divide(b3));

    }

}

