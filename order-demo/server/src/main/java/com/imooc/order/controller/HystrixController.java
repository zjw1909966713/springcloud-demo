package com.imooc.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @author 张进文
 * @ClassName HystrixController
 * @Description TODO
 * @Date 2019/4/11 10:50
 * @Version 1.0
 */
@RestController
@DefaultProperties(defaultFallback ="defaultFallback" )
public class HystrixController {






    //超时设置
//    @HystrixCommand(commandProperties ={@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")} )

//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name ="circuitBreaker.enabled" ,value = "true"),                   //设置熔断
//            @HystrixProperty(name ="circuitBreaker.requestVolumeThreshold" ,value = "10"),
//            @HystrixProperty(name ="circuitBreaker.sleepWindowInMilliseconds" ,value = "10000"),
//            @HystrixProperty(name ="circuitBreaker.errorThresholdPercentage" ,value = "60")
//
//    })


   @HystrixCommand
    //服务容错调用相关方法
    //@HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(@RequestParam(value = "number",defaultValue = "1") Integer number){

        if(number%2==0){
            return "success";
        }


        RestTemplate restTemplate=new RestTemplate();
        String resStr = restTemplate.postForObject("http://localhost:8085/product/listForOrder", Arrays.asList("1552547974390121167", "1552974591235208602"), String.class);
        return resStr;
    }


    private String fallback(){
        return "太拥挤了，请稍后再试";
    }

    private String defaultFallback(){
        return "默认提示：太拥挤了，请稍后再试";
    }
}
