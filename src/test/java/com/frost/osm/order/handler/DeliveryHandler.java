package com.frost.osm.order.handler;

import com.frost.osm.Handler;
import com.frost.osm.StateMachineDomain;
import com.frost.osm.order.enums.OrderState;


public class DeliveryHandler implements Handler<OrderState> {


    @Override
    public void handle(StateMachineDomain domain, OrderState orderState) {
        System.out.println(String.format("%s --> %s", domain.getCurrentState().toString(), orderState.toString()));
        domain.setNextState(orderState);

        System.out.println("========订单发货========");
    }
}
