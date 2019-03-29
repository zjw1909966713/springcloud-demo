package com.imooc.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 张进文
 * @ClassName CartDTO
 * @Description TODO
 * @Date 2019/3/20 14:52
 * @Version 1.0
 */
@Data
public class CartDTO {

    /**
     * @description: TODO
     * @author: 张进文
     * @param:
     * @return:
     * @date: 2019/3/20 14:53
     * @version: 1.0
     */
    private String productId;


    /** *
     * @description: TODO
     * @author: 张进文
     * @param:
     * @return:
     * @date: 2019/3/20 14:54
     * @version: 1.0
     */
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }


}
