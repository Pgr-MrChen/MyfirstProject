package com.imooc.sell.service.impl;

import com.imooc.sell.entity.ProductInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    void findById() {
        ProductInfo productInfo= productService.findById("19001");
        Assert.assertEquals("19001",productInfo.getProductId());
    }

    @Test
    void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    void findAll() {
        /*Pageable pageable = new PageRequest(0,3,null);
        Page<ProductInfo> productInfoPage = productService.findAll(pageable);*/
    }

    @Test
    void save() {
    }
}