package com.imooc.product.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 张进文
 * @ClassName ProductInfoVO
 * @Description TODO
 * @Date 2019/3/19 11:15
 * @Version 1.0
 */
@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;


    @JsonProperty("description")
    private String productDescription;


    @JsonProperty("icon")
    private String productIcon;


}
