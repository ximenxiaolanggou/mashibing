package top.damoncai.designattern.observer;

/**
 * @author zhishun.cai
 * @date 2021/1/24 14:06
 */

public class DadObserver extends Observer<Child>{
    @Override
    public void wakeUp(Event<Child> event) {
        Child child = event.getSource();
        System.out.println("dad feed：" + child.getName());
    }

    @Override
    void laugh(Event<Child> event) {
        Child child = event.getSource();
        System.out.println("dad laugh：" + child.getName());
    }
}
