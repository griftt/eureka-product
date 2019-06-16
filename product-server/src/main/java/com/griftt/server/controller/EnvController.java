package com.griftt.server.controller;


import com.griftt.server.stream.StreamClient;
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


    @Value("${env}")
    private String env;

    @GetMapping("test")
    public String getEnv(){
        return  env;
    }


    @GetMapping("stream")
    public String testSTreamMq(){
        streamClient.outputMsg().send(MessageBuilder.withPayload("hello"+new Date()).build());

        return  "ok";
    }
}
