package top.damoncai.designattern.observer;

/**
 * @author zhishun.cai
 * @date 2021/1/24 13:58
 */

public abstract class Observer<T>{

    abstract void wakeUp(Event<T> event);

    abstract void laugh(Event<T> event);
}
