package com.imooc.sell.dao;

import com.imooc.sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {
}
