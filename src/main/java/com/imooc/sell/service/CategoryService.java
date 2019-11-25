package com.imooc.sell.service;

import com.imooc.sell.entity.ProductCategory;

import java.util.List;

public interface CategoryService {

    //通过id查询
    ProductCategory findOne(Integer categoryId);

    //查询所有
    List<ProductCategory> findAll();

    //通过类目编号查询
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    //更新
    ProductCategory save(ProductCategory productCategory);

    //删除
    void deleteById(Integer categoryId);
}
