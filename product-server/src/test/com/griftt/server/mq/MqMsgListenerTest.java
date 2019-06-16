package com.griftt.server.mq;

import com.griftt.server.EurekaProductApplication;
import com.griftt.server.mq.work.Receiver;
import com.griftt.server.mq.work.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest(classes = {EurekaProductApplication.class})
@RunWith(SpringRunner.class)
public class MqMsgListenerTest {

    @Autowired
    private MqMsgListener msgListener;
    @Autowired
    private MqSender mqSender;
    @Autowired
    private Receiver receiver;
    @Autowired
    private Sender sender;
    @Test
    public void process() {
        sender.send();
    }
}