package com.imooc.sell.dao;

import com.imooc.sell.entity.OrderDetail;
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
class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1002");
        orderDetail.setOrderId("001");
        orderDetail.setProductId("19002");
        orderDetail.setProductName("青椒肉丝");
        orderDetail.setProductPrice(new BigDecimal(13));
        orderDetail.setProductQuantity(3);
        orderDetail.setProductIcon("xxxx.png");
        OrderDetail result = orderDetailDao.save(orderDetail);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = orderDetailDao.findByOrderId("001");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}