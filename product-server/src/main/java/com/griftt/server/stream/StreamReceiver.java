package com.griftt.server.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@EnableBinding(StreamClient.class)
@Slf4j
@Component
public class StreamReceiver {

    @StreamListener(StreamClient.Input)
    @SendTo(StreamClient.Return) //处理消息后返回信息
    public boolean process(Object msg){
        System.err.println(msg);
       log.info("msg1：{}",msg);
       return true;
    }


    /**
     * 对消息处理后的确认的返回
     * @param msg
     */
    @StreamListener(StreamClient.Return)
    public void processReturn(Object msg){
        System.err.println(msg);
        log.info("msg return ：{}",msg);

    }
}
