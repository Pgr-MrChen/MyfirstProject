package com.imooc.sell.controller;

import com.imooc.sell.VO.ProductInfoVO;
import com.imooc.sell.VO.ProductVO;
import com.imooc.sell.VO.ResultVO;
import com.imooc.sell.entity.ProductCategory;
import com.imooc.sell.entity.ProductInfo;
import com.imooc.sell.service.CategoryService;
import com.imooc.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResultVO list(){


        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2.查询类目(一次性查询)

        //传统方法
       /* List<Integer> categoryTypeList = new ArrayList<>();
        for (ProductInfo productInfo:productInfoList
             ) {
            categoryTypeList.add(productInfo.getCategoryType());
        }
*/
        //精简方法(java8,lambda表达式)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory:productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList
                 ) {
                ProductInfoVO productInfoVO = new ProductInfoVO();
                productInfoVO.setProductId(productInfo.getProductId());
                productInfoVO.setProductName(productInfo.getProductName());
                productInfoVO.setProductPrice(productInfo.getProductPrice());
                productInfoVO.setProductDescription(productInfo.getProductDescription());
                productInfoVO.setProductIcon(productInfo.getProductIcon());
                productInfoVOList.add(productInfoVO);
            }
            productVO.setCategoryFoods(productInfoVOList);
        }

        ResultVO resultVO = new ResultVO();
        //resultVO.setData();

        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(Arrays.asList());

        return resultVO;
    }

}
