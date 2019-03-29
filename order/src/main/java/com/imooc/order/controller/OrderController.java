package com.imooc.order.controller;

import com.imooc.order.VO.ResultVO;
import com.imooc.order.converter.OrderForm2OrderDTOConverter;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.enums.ResultEnum;
import com.imooc.order.exception.OrderException;
import com.imooc.order.exception.SellException;
import com.imooc.order.form.OrderForm;
import com.imooc.order.service.OrderService;
import com.imooc.order.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张进文
 * @ClassName OrderController
 * @Description TODO
 * @Date 2019/3/19 15:06
 * @Version 1.0
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /** *
     * @description: 1.
     * 1. 参数校验
     * 2.查询商品信息（调用商品服务）
     * 3.计算总价
     * 4.扣库存（调用商品服务）
     * 5.订单入库
     *
     * @author: 张进文
     * @param: []
     * @return: void
     * @date: 2019/3/19 15:07
     * @version: 1.0
     */
    @PostMapping("/create")
    public ResultVO create(OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】 参数不正确，orderForm={}",orderForm);
            throw  new OrderException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }

        //OrderForm ->OrderDTO

        OrderDTO orderDTO= OrderForm2OrderDTOConverter.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车信息为空");
            throw  new SellException(ResultEnum.CART_EMPTY);
        }


        OrderDTO orderDTO1 = orderService.create(orderDTO);
        Map<String,String> map=new HashMap<>();
        map.put("orderId",orderDTO1.getOrderId());
        return ResultVOUtil.success(map);

    }
}
