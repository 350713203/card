package test.com.card.dao;

import com.card.dao.CardticketMapper;
import com.card.entity.Cardticket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;


public class CardticketMapperTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-configs.xml");
        CardticketMapper cardticketMapper = context.getBean(CardticketMapper.class);
        Cardticket cardticket=new Cardticket();
        cardticket.setTicketPos("哈萨克斯坦");
        int i = cardticketMapper.insertSelective(cardticket);
        System.out.println(i);

    }

}
