package com.imooc.order.exception;

/**
 * @author 张进文
 * @ClassName OrderException
 * @Description TODO
 * @Date 2019/3/19 15:24
 * @Version 1.0
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
