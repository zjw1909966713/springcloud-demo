package com.imooc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 张进文
 * @ClassName MqReceiver
 * @Description 接收目前消息
 * @Date 2019/3/25 16:59
 * @Version 1.0
 */
@Component
@Slf4j
public class MqReceiver {


   //1. @RabbitListener(queues = "myQueue")
    //2.自动创建队列 @RabbitListener(queuesToDeclare =@Queue("myQueue"))
    //3.自动创建，Exchange和Queue绑定

    @RabbitListener(bindings=@QueueBinding(value = @Queue("myQueue"),exchange = @Exchange("myExchange")))
    public void process(String message){
        log.info("MqReceiver:{}",message);

    }




    /** *
     * @description: 数码供应商服务，接收消息
     * @author: 张进文
     * @param: [message]
     * @return: void
     * @date: 2019/3/26 15:25
     * @version: 1.0
     */
    @RabbitListener(bindings=@QueueBinding(exchange =
        @Exchange("myOrder"),key = "computer",value = @Queue("computerOrder")
    ))
    public void processComputer(String message){
        log.info("computer MqReceiver:{}",message);

    }



    /** *
     * @description: 数码供应商服务，接收消息
     * @author: 张进文
     * @param: [message]
     * @return: void
     * @date: 2019/3/26 15:25
     * @version: 1.0
     */
    @RabbitListener(bindings=@QueueBinding(exchange =
    @Exchange("myOrder"),key = "fruit",value = @Queue("fruitOrder")
    ))
    public void processFruit(String message){
        log.info("fruit MqReceiver:{}",message);

    }


}
