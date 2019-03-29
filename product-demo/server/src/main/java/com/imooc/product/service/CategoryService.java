package com.imooc.product.service;

import com.imooc.product.dataobject.ProductCategory;

import java.util.List;

/**
 * @description: TODO
 * @author: 张进文
 * @param:
 * @return:
 * @date: 2019/3/19 10:27
 * @version: 1.0
 */
public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
