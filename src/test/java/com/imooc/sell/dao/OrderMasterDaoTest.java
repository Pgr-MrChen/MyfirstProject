package com.imooc.sell.dao;

import com.imooc.sell.entity.OrderMaster;
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
class OrderMasterDaoTest {

    @Autowired
    private OrderMasterDao orderMasterDao;

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("002");
        orderMaster.setBuyerName("小栋");
        orderMaster.setBuyerAddress("重庆孵化室");
        orderMaster.setBuyerPhone("12345678910");
        orderMaster.setBuyerOpenid("123456");
        orderMaster.setOrderAmount(new BigDecimal(20));
        OrderMaster result = orderMasterDao.save(orderMaster);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByBuyerOpenid() {
        List<OrderMaster> orderMasterList = orderMasterDao.findByBuyerOpenid("123456");
        Assert.assertNotEquals(0,orderMasterList.size());
    }
}