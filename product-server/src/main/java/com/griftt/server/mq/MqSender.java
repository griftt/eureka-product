package com.griftt.server.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * 发送者
 */
@Configuration
public class MqSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String content=" server send to you  queue ";
        rabbitTemplate.convertAndSend("hello",content);
    }
}
