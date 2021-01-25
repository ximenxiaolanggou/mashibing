package top.damoncai.designattern.observer;

/**
 * @author zhishun.cai
 * @date 2021/1/24 14:03
 */

public class WakeUpEvent extends Event<Child> {
    @Override
    void onEvent() {
        System.out.println("wa wa cry ~~~");
    }

    public WakeUpEvent(Child child){
        t = child;
    }
}
