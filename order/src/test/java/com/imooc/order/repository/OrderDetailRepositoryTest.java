package com.imooc.order.repository;

import com.imooc.order.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Test
    public void test1(){


        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("11111");
        orderDetail.setOrderId("22222");
        OrderDetail save = orderDetailRepository.save(orderDetail);
        System.out.println("============================"+save.getDetailId());
    }

}