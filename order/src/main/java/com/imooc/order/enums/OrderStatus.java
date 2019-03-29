package com.imooc.order.enums;

import lombok.Getter;

/**
 * @description: TODO
 * @author: 张进文
 * @param:
 * @return:
 * @date: 2019/3/19 14:33
 * @version: 1.0
 */
@Getter
public enum OrderStatus {

    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"取消"),;

    private Integer code;
    private String  message;

    OrderStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
