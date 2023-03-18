package center.helloworld.designpattern2023._01_observer.example_01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhishun.cai
 * @create 2023/3/9
 * @note 具体的实现方式
 */
public class ConcreteSubject implements Subject {

    List<Observer> observers = new ArrayList();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void advice() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
