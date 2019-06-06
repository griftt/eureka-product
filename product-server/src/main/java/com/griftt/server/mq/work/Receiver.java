package com.griftt.server.mq.work;


import com.griftt.server.entity.Work;
import com.griftt.server.mq.rabbitenum.QueueNameEnum;
import com.griftt.server.mq.rabbitenum.TopExchangeRoutingKeyEnum;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Receiver {

    @RabbitListener(queues ={"topic.messageSec.sec"})
    public void getTopMsg(Work work){
        System.err.println("work receiver:" +work);
    }

}
