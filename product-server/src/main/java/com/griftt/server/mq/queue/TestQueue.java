package com.griftt.server.mq.queue;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestQueue {



    /**
     * 2.配置4个队列来处理
     *
     */
    @Bean
    public Queue queueMessageOne(){
        return new Queue("topic.queueMessageOne");
    }

    @Bean
    public Queue messageSec(){
        return new Queue("topic.messageSec.sec");
    }

    @Bean
    public Queue queueMessageThi(){
        return new Queue("queueMessageThi");
    }

    @Bean
    public Queue messageFour(){
        return new Queue("messageFour");
    }


}
