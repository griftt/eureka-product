package com.griftt.server.mq.work;


import com.griftt.server.entity.Work;
import com.griftt.server.mq.rabbitenum.ExchangeNameEnum;
import com.griftt.server.mq.rabbitenum.TopExchangeRoutingKeyEnum;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        Work work = new Work();
        work.setOne(1);
        work.setTwo("topex");
        rabbitTemplate.convertAndSend(ExchangeNameEnum.TOPIC.toString(), TopExchangeRoutingKeyEnum.ROUTEONE.toString(),work);
    }

}
