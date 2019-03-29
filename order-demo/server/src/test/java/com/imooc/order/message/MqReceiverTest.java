package com.imooc.order.message;

import com.imooc.order.ServerApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;


@Component
public class MqReceiverTest extends ServerApplicationTests{


    @Autowired
    private AmqpTemplate amqpTemplate;


    @Test
    public void send(){

        System.out.println("=============发送详细====================");
        amqpTemplate.convertAndSend("myQueue","now:"+new Date());

    }

    @Test
    public void sendComputer(){

        System.out.println("=============发送计算机===================");
        amqpTemplate.convertAndSend("myOrder","computer","now-------"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));

    }



    @Test
    public void sendFruit(){

        System.out.println("=============发送水果===================");
        amqpTemplate.convertAndSend("myOrder","fruit","now-------"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));

    }



}