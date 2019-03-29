package com.imooc.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张进文
 * @ClassName ServerController
 * @Description TODO
 * @Date 2019/3/19 15:59
 * @Version 1.0
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg(){
        return "this is product' msg";
    }
}
