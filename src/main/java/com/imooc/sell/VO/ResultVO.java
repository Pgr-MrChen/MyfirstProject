package com.imooc.sell.VO;

import lombok.Data;

/**
 * 前端结果信息
 * @param <T>
 */
@Data
public class ResultVO<T> {
    //错误码
    private Integer code;

    //提示信息
    private String msg;

    //具体数据
    private T data;
}
