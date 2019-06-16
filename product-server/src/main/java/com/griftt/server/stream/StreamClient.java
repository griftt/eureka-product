package com.griftt.server.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.handler.annotation.SendTo;

import java.lang.annotation.Inherited;

public interface StreamClient {


    String Input="myInput";
    String Return="myreturnIN";
    String ReturnOut="myreturnOUt";
    String OutPut="myOutput";

    /**
     *
     * 消费者
     * @return
     */
    @Input(Input)
    SubscribableChannel inputMsg();

    /**
     * 生产者
     * @return
     */
    @Output(OutPut)
    MessageChannel outputMsg();

    @Input(Return)
    SubscribableChannel inputMsg2();

    @Output(ReturnOut)
    MessageChannel outputMsg2();

}
