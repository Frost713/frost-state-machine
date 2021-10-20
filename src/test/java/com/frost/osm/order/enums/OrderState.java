package com.frost.osm.order.enums;


public enum OrderState {

    // 提交订单
    SUBMIT_ORDER,

    // 待支付
    WAIT_PAY,

    // 待发货
    WAIT_DELIVERY,

    // 待收货
    WAIT_RECEIVE,

    // 订单完成
    COMPLETE,

    // 交付订单
    DELIVERY_ORDER,

    // 数据工程订单
    DATA_PROJECT_ORDER,

    // 订单关闭
    CLOSED
}
