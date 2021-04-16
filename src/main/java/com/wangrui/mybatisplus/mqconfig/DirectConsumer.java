package com.wangrui.mybatisplus.mqconfig;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@RabbitListener(queues = "TestDirectQueue") //监听的队列名
public class DirectConsumer {

    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
    }

}
