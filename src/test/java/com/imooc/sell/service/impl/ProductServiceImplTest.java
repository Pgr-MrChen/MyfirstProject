package com.imooc.sell.service.impl;

import com.imooc.sell.entity.ProductInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findById() {
        ProductInfo productInfo= productService.findById("19001");
        Assert.assertEquals("19001",productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    /*@Test
    public void findAll() {
        // 排序方式，这里是以“recordNo”为标准进行降序
        Sort sort = new Sort(Sort.Direction.DESC, "recordNo");
        PageRequest pageable = new PageRequest(0,2,sort);
        Page<ProductInfo> productInfoPage = productService.findAll(pageable);
    }*/

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo("19002","青椒肉丝",new BigDecimal(13),50,"好吃的青椒肉丝！","xxxx.png",0,3);
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }
}