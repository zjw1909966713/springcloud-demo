package com.imooc.product.service;

import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.dto.CartDTO;

import java.util.List;

/** *
 * @description: TODO
 * @author: 张进文
 * @param:
 * @return:
 * @date: 2019/3/18 16:36
 * @version: 1.0
 */
public interface ProductService {


    /** *
     * @description: 查询所有上架商品列表
     * @author: 张进文
     * @param: []
     * @return: java.util.List<com.imooc.product.dataobject.ProductInfo>
     * @date: 2019/3/18 16:37
     * @version: 1.0
     */
    List<ProductInfo> findUpAll();


    /** *
     * @description: TODO
     * @author: 张进文
     * @param: [productIdList]
     * @return: java.util.List<com.imooc.product.dataobject.ProductInfo>
     * @date: 2019/3/20 13:56
     * @version: 1.0
     */
    List<ProductInfo> findList(List<String> productIdList);


    /**
     * @description: 扣库存
     * @author: 张进文
     * @param: [cartDTOList]
     * @return: void
     * @date: 2019/3/20 14:54
     * @version: 1.0
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
