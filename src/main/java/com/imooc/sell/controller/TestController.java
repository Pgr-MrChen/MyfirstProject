package com.imooc.sell.controller;

import com.imooc.sell.dao.ProductCategoryDao;
import com.imooc.sell.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @GetMapping(value = "/findone")
    public String findOne(){
        Optional<ProductCategory> productCategory = productCategoryDao.findById(1);
        return productCategory.toString();
    }
}
