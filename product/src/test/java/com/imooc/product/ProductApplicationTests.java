package com.imooc.product;

import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.repository.ProductInfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductApplicationTests {


	@Autowired
	private ProductInfoRepository productInfoRepository;

	@Test
	public void contextLoads() {
		List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(0);
		System.out.println(productInfoList.size());
	}

}
