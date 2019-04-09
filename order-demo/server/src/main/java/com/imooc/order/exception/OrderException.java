package com.imooc.order.exception;

import com.imooc.order.enums.ResultEnum;

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
    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();

    }
}
