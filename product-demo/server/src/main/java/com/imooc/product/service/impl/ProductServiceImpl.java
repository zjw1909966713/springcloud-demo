package com.imooc.product.service.impl;

import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.common.ProductInfoOutput;
import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.enums.ProductStatusEnum;
import com.imooc.product.enums.ResultEnum;
import com.imooc.product.exception.ProductException;
import com.imooc.product.repository.ProductInfoRepository;
import com.imooc.product.service.ProductService;
import com.imooc.product.util.JsonUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author 张进文
 * @ClassName ProductServiceImpl
 * @Description TODO
 * @Date 2019/3/18 16:38
 * @Version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private AmqpTemplate amqpTemplate;



    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
    @Override
    public List<ProductInfoOutput> findList(List<String> productIdList) {
       return productInfoRepository.findByProductIdIn(productIdList).stream()
                .map(e -> {
                    ProductInfoOutput output = new ProductInfoOutput();
                    BeanUtils.copyProperties(e, output);
                    return output;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void decreaseStock(List<DecreaseStockInput> cartDTOList) {

             List<ProductInfoOutput> outputList=decreaseStockProcess(cartDTOList);
            //发送mq消息
            amqpTemplate.convertAndSend("productInfo", JsonUtil.toJson(outputList));


    }


    @Transactional(rollbackFor =Exception.class)
    public List<ProductInfoOutput> decreaseStockProcess(List<DecreaseStockInput> cartDTOList) {

        List<ProductInfoOutput>  outputList=new ArrayList<>();
        for (DecreaseStockInput cartDTO:cartDTOList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cartDTO.getProductId());

            //判断商品是否存在
            if (!productInfoOptional.isPresent()){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            ProductInfo productInfo=productInfoOptional.get();
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();

            //库存是否存在
            if(result<0){
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);

            ProductInfoOutput productInfoOutput=new ProductInfoOutput();
            BeanUtils.copyProperties(productInfo,productInfoOutput);
            outputList.add(productInfoOutput);
        }
        return outputList;
    }
}
