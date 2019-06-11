package com.griftt.server.mq.work;


import com.griftt.server.entity.Work;
import com.griftt.server.mq.rabbitenum.QueueNameEnum;
import com.griftt.server.mq.rabbitenum.TopExchangeRoutingKeyEnum;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Receiver {

    //1.@RabbitListener(queues ={"topic.messageSec.sec"})
    //2.此处及直接声明新建一个队列
    @RabbitListener(queuesToDeclare =@Queue("topic.messageSec.mime"))
    //自动创建并绑定队列
   /* @RabbitListener(bindings=@QueueBinding(
            value=@Queue("mymsg"),
            exchange =@Exchange("myexchange"),
            key = "msg"
    ))*/
    public void getTopMsg(Work work){
        System.err.println("work receiver:" +work);
    }
    @RabbitListener(bindings=@QueueBinding(
            value=@Queue("mymsg"),
            exchange =@Exchange("myexchange"),
            key = "msg"
    ))
    public void testTopMsg(Work work){
        System.err.println("work receiver:" +work);
    }
}
