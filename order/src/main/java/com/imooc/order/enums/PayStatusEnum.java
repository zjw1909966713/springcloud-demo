package com.imooc.order.enums;

import lombok.Getter;

/** *
 * @description: TODO
 * @author: 张进文
 * @param:
 * @return:
 * @date: 2019/3/19 14:35
 * @version: 1.0
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功")

    ;

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
