package com.imooc.product.repository;

import com.imooc.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/** *
 * @description: TODO
 * @author: 张进文
 * @param:
 * @return:
 * @date: 2019/3/18 15:57
 * @version: 1.0
 */
@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String>{

    /** *
     * @description: TODO
     * @author: 张进文
     * @param: [productStatus]
     * @return: java.util.List<com.imooc.product.dataobject.ProductInfo>
     * @date: 2019/3/18 16:00
     * @version: 1.0
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

    /** *
     * @description: TODO
     * @author: 张进文
     * @param: [productIdList]
     * @return: java.util.List<com.imooc.product.dataobject.ProductInfo>
     * @date: 2019/3/20 13:55
     * @version: 1.0
     */
    List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
