package com.imooc.sell.dao;

import com.imooc.sell.entity.ProductInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductInfoDaoTest {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo("19001","鸡蛋饼", new BigDecimal(5.5), 20, "新鲜的鸡蛋饼", "xxx.png", 0, 1);
        ProductInfo result = productInfoDao.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfoList = productInfoDao.findByProductStatus(0);
        Assert.assertNotEquals(0, productInfoList.size());
    }
}