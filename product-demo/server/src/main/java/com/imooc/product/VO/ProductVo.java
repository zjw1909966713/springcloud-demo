package com.imooc.product.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author 张进文
 * @ClassName ProductVo
 * @Description TODO
 * @Date 2019/3/19 11:06
 * @Version 1.0
 */
@Data
public class ProductVo {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;


    @JsonProperty("foods")
    List<ProductInfoVO> productInfoVOList;

}
