package com.griftt.server.controller;


import com.griftt.server.stream.StreamClient;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RequestMapping("env")
@RestController
@RefreshScope
public class EnvController {


    @Autowired
    private StreamClient streamClient;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${env}")
    private String env;

    @GetMapping("test")
    public String getEnv(){
        return  env;
    }

    @GetMapping("test2")
    public String getEnv2(){
        return  env;
    }


    @GetMapping("stream")
    public String testSTreamMq(){
        streamClient.outputMsg().send(MessageBuilder.withPayload("hello"+new Date()).build());
        return  "ok";
    }
    @GetMapping("sto")
    public String convertAndSend(){
        String msg="hello"+new Date();
        amqpTemplate.convertAndSend("productInfo","#",msg);
        return  "ok";
    }


    @GetMapping("send")
    public String sendMq(){
       amqpTemplate.convertAndSend("ex","#","hello");
        return  "ok";
    }
}
