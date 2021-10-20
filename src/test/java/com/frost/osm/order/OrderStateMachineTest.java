package com.frost.osm.order;

import com.frost.osm.Handler;
import com.frost.osm.StateMachine;
import com.frost.osm.StateMachineConfigurationHolder;
import com.frost.osm.order.bean.Order;
import com.frost.osm.order.enums.OrderEvent;
import com.frost.osm.order.enums.OrderState;
import com.frost.osm.order.handler.*;
import org.junit.Assert;
import org.junit.Test;


public class OrderStateMachineTest {


    @Test
    public void testStateMachine() {

        StateMachineConfigurationHolder<OrderState, OrderEvent, Handler> holder = new StateMachineConfigurationHolder();


        holder.source(OrderState.SUBMIT_ORDER)
                .event(OrderEvent.SUBMIT_ORDER)
                .handler(new SubmitOrderHandler())
                .target(OrderState.WAIT_PAY)
                .build();



        holder.source(OrderState.WAIT_PAY)
                .event(OrderEvent.CANCEL)
                .handler(new CancelHandler())
                .target(OrderState.CLOSED)
                .build();


        holder.source(OrderState.WAIT_PAY)
                .event(OrderEvent.PAY)
                .handler(new PayHandler())
                .target(OrderState.WAIT_DELIVERY)
                .build();


        holder.source(OrderState.WAIT_DELIVERY)
                .event(OrderEvent.DELIVERY)
                .handler(new DeliveryHandler())
                .target(OrderState.WAIT_RECEIVE)
                .build();


        holder.source(OrderState.WAIT_RECEIVE)
                .event(OrderEvent.CONFIRM_RECEIVE)
                .handler(new ConfirmReceviveHandler())
                .target(OrderState.COMPLETE)
                .build();



        StateMachine<OrderState, OrderEvent, Handler> stateMachine = new StateMachine<>(holder);



        Order order = new Order();
        order.setOrderNo(10086L);
        order.setState(OrderState.SUBMIT_ORDER);


        stateMachine.transition(order, OrderEvent.SUBMIT_ORDER);
        Assert.assertEquals(OrderState.WAIT_PAY, order.getState());

        stateMachine.transition(order, OrderEvent.PAY);
        Assert.assertEquals(OrderState.WAIT_DELIVERY, order.getState());

        stateMachine.transition(order, OrderEvent.DELIVERY);
        Assert.assertEquals(OrderState.WAIT_RECEIVE, order.getState());

        stateMachine.transition(order, OrderEvent.CONFIRM_RECEIVE);
        Assert.assertEquals(OrderState.COMPLETE, order.getState());
    }
}
