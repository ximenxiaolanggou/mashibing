package top.damoncai.designattern.observer;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhishun.cai
 * @date 2021/1/24 14:03
 */
@Data
public class Child {

    private String name;

    private List<Observer> observers = new ArrayList<>();

    public Child setObservers(Observer observer){
        observers.add(observer);
        return this;
    }

    public void wake() {
        Event<Child> event = new WakeUpEvent(this);
        event.onEvent();
        for (Observer observer : observers) {
            observer.wakeUp(event);
        }
    }

    public void laugh() {
        Event<Child> event = new LaugnEvent(this);
        event.onEvent();

        for (Observer observer : observers) {
            observer.laugh(event);
        }
    }
}
