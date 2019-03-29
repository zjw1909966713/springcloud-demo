package com.imooc.order.client;

import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product")
@Component
public interface ProductClient {
    @GetMapping("/msg")
    String productMsg();


    @PostMapping("/product/listForOrder")
     List<ProductInfo> listForOrder(List<String> productIdList);


    @PostMapping("/product/decreaseStock")
      void decreaseStock(List<CartDTO> cartDTOList);

}
