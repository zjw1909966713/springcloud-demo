package com.imooc.product.service;

import com.imooc.product.dto.CartDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    public void decreaseStock() throws Exception {
        CartDTO cartDTO=new CartDTO("1552447742679717453",55);
        productService.decreaseStock(Arrays.asList(cartDTO));
    }

}