package center.helloworld.designpattern2023._01_observer.example_01;

/**
 * @author zhishun.cai
 * @create 2023/3/9
 * @note 观察者1
 */
public class Observer1 implements Observer{

    @Override
    public void update() {
        System.out.println("Observer1接收到更新消息~~");
    }
}
