package com.imooc.sell.dao;

import com.imooc.sell.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 订单主页
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster,String>  {

    List<OrderMaster> findByBuyerOpenid(String buyerOpenid);
}
