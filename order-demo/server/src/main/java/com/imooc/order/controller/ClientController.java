package com.imooc.order.controller;

import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dto.CartDTO;
import com.imooc.product.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author 张进文
 * @ClassName ClientController
 * @Description TODO
 * @Date 2019/3/19 16:01
 * @Version 1.0
 */
@RestController
@Slf4j
public class ClientController  {

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @Autowired
    private  RestTemplate restTemplate;


    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        //1.第一种方式(直接使用restTemplate url写死)
       /* RestTemplate restTemplate=new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);*/


        //2.第二种方式 （loadBalancerClient ）
        ServiceInstance serviceInstance = loadBalancerClient.choose("product");
        String url = String.format("http://%s:%S", serviceInstance.getHost(), serviceInstance.getPort()) + "/msg";
        RestTemplate restTemplate=new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

       //3.第三种方式(利用@LoadBalanced 注解，可在restTemplate)
        /*String response = restTemplate.getForObject("http://product/msg", String.class);*/


        log.info("response={}"+response);
        return response;

    }


   /* @GetMapping("/getMsg")
    public String  getMsg(){

        String response=productClient.productMsg();
        log.info("response={}"+response);
        return response;

    }*/

   /* @GetMapping("/getProductList")
    public String getProductList(){
        List<ProductInfo> productInfoList = productClient.listForOrder(Arrays.asList("1552974465244309685"));
        log.info("response={}"+productInfoList);
        return "ok";
    }

    @GetMapping("/productDecreaseStock")
    public String productDecreaseStock(){
        productClient.decreaseStock(Arrays.asList(new CartDTO("1552974591235208602",223)));
        return "ok";
    }*/


}
