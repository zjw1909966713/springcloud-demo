package com.imooc.product.VO;

import lombok.Data;

/**
 * @author 张进文
 * @ClassName ResultVO
 * @Description TODO
 * @Date 2019/3/19 11:05
 * @Version 1.0
 */
@Data
public class ResultVO<T> {

    private Integer code;
    private String msg;
    private T data;

}
