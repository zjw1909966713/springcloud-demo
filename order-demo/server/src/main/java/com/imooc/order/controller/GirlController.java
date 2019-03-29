package com.imooc.order.controller;

import com.imooc.order.config.GirlProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张进文
 * @ClassName GirlController
 * @Description TODO
 * @Date 2019/3/25 15:55
 * @Version 1.0
 */
@RestController
@RequestMapping("/girl")
public class GirlController {

    @Autowired
    private GirlProperty girlProperty;

    @GetMapping("print")
    public String print(){
        return "namge:"+girlProperty.getName()+",age:"+girlProperty.getAge();
    }
}
