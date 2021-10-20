package com.frost.osm;


public interface Handler<S> {


    /**
     * 业务处理方法
     * @param domain
     * @param state
     */
    void handle(StateMachineDomain domain, S state);
}
