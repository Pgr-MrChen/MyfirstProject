package com.imooc.sell.dao;

import com.imooc.sell.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void findOneTest(){
        ProductCategory productCategory = productCategoryDao.findById(1).get();
        System.out.println(productCategory.toString());
    }

    @Test
    public void addTest(){
        ProductCategory productCategory = productCategoryDao.findById(2).get();
        productCategory.setCategoryType(5);
        productCategory.setCategoryName("特色");
        productCategory.setCreateTime(productCategory.getCreateTime());
        productCategory.setUpdateTime(productCategory.getUpdateTime());
        productCategoryDao.save(productCategory);
    }
}