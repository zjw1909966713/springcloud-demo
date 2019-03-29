package com.imooc.product.controller;

import com.imooc.product.VO.ProductInfoVO;
import com.imooc.product.VO.ProductVo;
import com.imooc.product.VO.ResultVO;
import com.imooc.product.dataobject.ProductCategory;
import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.dto.CartDTO;
import com.imooc.product.service.CategoryService;
import com.imooc.product.service.ProductService;
import com.imooc.product.util.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 张进文
 * @ClassName ProductController
 * @Description TODO
 * @Date 2019/3/18 15:31
 * @Version 1.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    

    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/list")
    public ResultVO list(){

        List<ProductInfo> productInfoList = productService.findUpAll();

        List<Integer> categoryTypeList = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());

        //3.从数据库查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);


        //4.构造数据
        List<ProductVo> productVoList=new ArrayList<>();
        for (ProductCategory productCategory:categoryList){
            ProductVo productVo=new ProductVo();
            productVo.setCategoryName(productCategory.getCategoryName());
            productVo.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList=new ArrayList<>();
            for (ProductInfo productInfo:productInfoList) {

                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                    productVo.setProductInfoVOList(productInfoVOList);
                }


            }


            productVoList.add(productVo);

        }



        return ResultVOUtil.success(productVoList);
    }


    /** *
     * @description: 获取商品列表(给订单服务用的)
     * @author: 张进文
     * @param: []
     * @return: java.util.List<com.imooc.product.dataobject.ProductInfo>
     * @date: 2019/3/20 13:51
     * @version: 1.0
     */
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList){
        return productService.findList(productIdList);
    }
    
    
    /** *
     * @description: TODO
     * @author: 张进文
     * @param: [cartDTOList]
     * @return: void
     * @date: 2019/3/20 15:31
     * @version: 1.0
     */
    @PostMapping("/decreaseStock")
    public  void decreaseStock(@RequestBody List<CartDTO> cartDTOList){
        productService.decreaseStock(cartDTOList);
    }
}
