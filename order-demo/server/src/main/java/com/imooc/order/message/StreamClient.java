package com.imooc.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface StreamClient {

    String INPUT="input";
    String OUTPUT="output";

    String INPUT1="input1";
    String OUTPUT1="output1";


   /** *
    * @description: 消费者
    * @author: 张进文
    * @param: []
    * @return: org.springframework.messaging.SubscribableChannel
    * @date: 2019/3/27 11:34
    * @version: 1.0
    */
    @Input(value =StreamClient.INPUT)
    SubscribableChannel input();



    /** *
     * @description: 生产值
     * @author: 张进文
     * @param: []
     * @return: org.springframework.messaging.MessageChannel
     * @date: 2019/3/27 11:34
     * @version: 1.0
     */
    @Output(value =StreamClient.OUTPUT)
    MessageChannel output();



    /** *
     * @description: 消费者
     * @author: 张进文
     * @param: []
     * @return: org.springframework.messaging.SubscribableChannel
     * @date: 2019/3/27 11:34
     * @version: 1.0
     */
    @Input(value =StreamClient.INPUT1)
    SubscribableChannel input1();



    /** *
     * @description: 生产值
     * @author: 张进文
     * @param: []
     * @return: org.springframework.messaging.MessageChannel
     * @date: 2019/3/27 11:34
     * @version: 1.0
     */
    @Output(value =StreamClient.OUTPUT1)
    MessageChannel output1();
}
