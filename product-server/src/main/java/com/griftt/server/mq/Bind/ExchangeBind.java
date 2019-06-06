package com.griftt.server.mq.Bind;

import com.griftt.server.mq.rabbitenum.TopExchangeRoutingKeyEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExchangeBind {

    @Bean("topicBinding")
    public Binding getTopicBinding(@Qualifier("queueMessageOne") Queue queue, @Qualifier("topicExchange")TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(TopExchangeRoutingKeyEnum.ROUTEONE);
    }
}
