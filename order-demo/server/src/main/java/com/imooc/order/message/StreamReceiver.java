package com.imooc.order.message;

import com.imooc.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author 张进文
 * @ClassName StreamReceiver
 * @Description TODO
 * @Date 2019/3/26 16:13
 * @Version 1.0
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {


    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.INPUT1)
    public String process(OrderDTO message){
        log.info("StreamReceiver:{}"+message);
        return "received.";

    }

    @StreamListener(StreamClient.INPUT1)
    public void process1(String message){
        log.info("StreamReceiver2222222222222:{}"+message);
    }
}
