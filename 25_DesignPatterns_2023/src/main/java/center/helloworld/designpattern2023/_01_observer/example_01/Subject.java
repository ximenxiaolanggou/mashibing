package center.helloworld.designpattern2023._01_observer.example_01;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象被观察者
 */
public interface Subject {


    /**
     * 添加观察者
     * @param observer
     */
    void attach(Observer observer);

    /**
     * 取消观察者
     * @param observer
     */
    void detach(Observer observer);

    /**
     * 通知
     */
    void advice();
}
