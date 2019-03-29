package com.imooc.product.enums;

import lombok.Getter;

/** *
 * @description: TODO
 * @author: 张进文
 * @param:
 * @return: 
 * @date: 2019/3/18 16:52
 * @version: 1.0
 */
@Getter
public enum ProductStatusEnum {

    UP(0, "上架"),
    DOWN(1,"下架"),
    ;
    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
