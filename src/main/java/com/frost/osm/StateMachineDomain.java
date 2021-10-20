package com.frost.osm;


public interface StateMachineDomain<S> {

   /**
    * 获取当前状态
    * @return
    */
   S getCurrentState();

   /**
    * 设置次态
    */
   void setNextState(S s);




}
