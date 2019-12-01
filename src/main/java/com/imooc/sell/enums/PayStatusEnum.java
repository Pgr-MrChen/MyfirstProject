package com.imooc.sell.enums;

import lombok.Getter;

/**
 * 订单支付状态
 */
@Getter
public enum PayStatusEnum {
    WAIT(0, "未支付"),
    SUCCESS(1,"成功支付")
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
