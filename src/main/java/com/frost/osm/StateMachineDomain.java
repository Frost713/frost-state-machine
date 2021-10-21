package com.frost.osm;


/**
 * @author frost
 */
public interface StateMachineDomain<S> {

   /**
    * 获取当前状态
    * @return
    */
   S getCurrentState();

   /**
    * 设置状态流转下个状态
    * @param s 状态
    */
   void setNextState(S s);




}
