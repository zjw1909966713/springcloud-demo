package com.imooc.order.service;

import com.imooc.order.dto.OrderDTO;

/**
 * @author Administrator
 */
public interface OrderService {

    /** *
     * @description: 创建订单
     * @author: 张进文
     * @param: [orderDTO]
     * @return: com.imooc.OrderDTO
     * @date: 2019/3/19 15:12
     * @version: 1.0
     */
    OrderDTO create(OrderDTO orderDTO);
    
    
    /** *
     * @description: 完结订单（只能卖家操作）
     * @author: 张进文
     * @param: [orderId]
     * @return: com.imooc.order.dto.OrderDTO
     * @date: 2019/4/9 11:59
     * @version: 1.0
     */
    OrderDTO finish(String orderId);
}
