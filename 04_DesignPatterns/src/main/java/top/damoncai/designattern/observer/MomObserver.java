package top.damoncai.designattern.observer;

/**
 * @author zhishun.cai
 * @date 2021/1/24 14:06
 */

public class MomObserver extends Observer<Child> {
    @Override
    public void wakeUp(Event<Child> event) {
        Child child = event.getSource();
        System.out.println("mom hug: " + child.getName());
    }

    @Override
    void laugh(Event<Child> event) {
        Child child = event.getSource();
        System.out.println("mom laugh: " + child.getName());
    }
}
