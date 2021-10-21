package com.frost.osm.order.bean;

import com.frost.osm.StateMachineDomain;
import com.frost.osm.order.enums.OrderState;
import lombok.Data;


@Data
public class Order implements StateMachineDomain<OrderState> {


    /**
     * 订单号
     */
    private Long orderNo;

    /**
     *  订单状态
     */
    private OrderState state;


    @Override
    public OrderState getCurrentState() {
        return this.state;
    }

    @Override
    public void setNextState(OrderState orderState) {
        this.state = orderState;
    }
}
