package com.imooc.product.exception;

import com.imooc.product.enums.ResultEnum;

/**
 * @author 张进文
 * @ClassName ProductException
 * @Description TODO
 * @Date 2019/3/20 14:59
 * @Version 1.0
 */
public class ProductException extends RuntimeException {
    private Integer code;

    public ProductException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
