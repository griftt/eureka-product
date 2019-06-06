package com.griftt.server.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

/**
 * 接收者
 */
@Configuration
@RabbitListener(queues = "hello")
public class MqMsgListener {

    @RabbitHandler
    public void process(String sender){
        System.err.println("receive"+sender );
    }


}
