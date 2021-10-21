package com.frost.osm;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;


/**
 * @author frost
 */
@Data
public class StateMachineConfiguration<S, E, H> {

    /**
     * 当前状态
     */
    private S currentState;

    /**
     * 存放事件处理器
     */
    private Map<E, H> eventHandlerMap;

    /**
     * 存放次态
     */
    private Map<E, S> nextStateMap;


    public StateMachineConfiguration(S currentState) {
        this.currentState = currentState;
        this.eventHandlerMap = new HashMap<>();
        this.nextStateMap = new HashMap<>();
    }
}
