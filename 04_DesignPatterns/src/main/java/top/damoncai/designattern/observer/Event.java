package top.damoncai.designattern.observer;

/**
 * @author zhishun.cai
 * @date 2021/1/24 13:59
 */

public abstract class Event<T> {

    T t;

    abstract void onEvent();

    T getSource() {
        return t;
    }
}
