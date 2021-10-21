package com.frost.osm;

/**
 * @author frost
 */
public class StateMachine<S, E, H extends Handler> {

    private StateMachineConfigurationHolder<S, E,H> stateMachineConfigurationHolder;

    public StateMachine(StateMachineConfigurationHolder<S, E,H> stateMachineConfigurationHolder) {
        this.stateMachineConfigurationHolder = stateMachineConfigurationHolder;
    }


    /**
     * 触发状态流转
     * @param domain
     * @param event
     */
    public void transition(StateMachineDomain<S> domain, E event) {
        S currentState = domain.getCurrentState();
        H handler = stateMachineConfigurationHolder.getHandler(currentState, event);
        S nextState = stateMachineConfigurationHolder.getNextState(currentState, event);
        handler.handle(domain, nextState);
    }




}
