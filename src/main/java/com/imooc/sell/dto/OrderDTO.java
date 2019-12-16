package com.imooc.sell.dto;

import com.imooc.sell.entity.OrderDetail;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单DTO
 */
@Data
public class OrderDTO {
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    //买家微信openid
    private String buyerOpenid;

    //订单总额
    private BigDecimal orderAmount;

    //订单状态, 默认为0新下单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    //支付状态, 默认0未支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;

    List<OrderDetail> orderDetailList;
}
