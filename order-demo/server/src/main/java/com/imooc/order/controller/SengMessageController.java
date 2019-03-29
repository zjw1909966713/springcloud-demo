package com.imooc.order.controller;

import com.imooc.order.dto.OrderDTO;
import com.imooc.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 张进文
 * @ClassName SengMessageController
 * @Description TODO
 * @Date 2019/3/26 16:15
 * @Version 1.0
 */
@RestController
public class SengMessageController {

    @Autowired
    private StreamClient streamClient;


    @GetMapping("/sendMessage")
    public String send(){

        String message="now-------"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date());
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setOrderId("456456");
        orderDTO.setBuyerName("zzzzzzzzzz");
        orderDTO.setBuyerAddress("aaaaaaaaaaa");
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());

        return "ok";
    }
}
