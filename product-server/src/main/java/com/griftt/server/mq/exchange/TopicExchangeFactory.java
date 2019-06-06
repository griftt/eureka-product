package com.griftt.server.mq.exchange;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicExchangeFactory {

    /**
     * .生成TopicExchange交换机
     */
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    /**
     * 2.生成HeadersExchange交换机
     */

    @Bean
    public HeadersExchange headersExchange(){
        return new HeadersExchange("headerExchange");
    }

    /**
     * 3.生成FanoutExchange交换机
     */

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }


}
