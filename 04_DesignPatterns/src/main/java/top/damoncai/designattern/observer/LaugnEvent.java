package top.damoncai.designattern.observer;

/**
 * @author zhishun.cai
 * @date 2021/1/24 14:41
 */

public class LaugnEvent extends Event<Child> {
    @Override
    void onEvent() {
        System.out.println("laugh ~~~");
    }

    public LaugnEvent(Child child){
        t = child;
    }
}
