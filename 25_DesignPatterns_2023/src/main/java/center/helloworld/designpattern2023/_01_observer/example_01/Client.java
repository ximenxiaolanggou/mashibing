package center.helloworld.designpattern2023._01_observer.example_01;

/**
 * @author zhishun.cai
 * @create 2023/3/9
 * @note
 */
public class Client {

    public static void main(String[] args) {

        Observer o1 = new Observer1();
        Observer o2 = new Observer1();

        Subject subject = new ConcreteSubject();

        //注册观察者
        subject.attach(o1);
        subject.attach(o2);

        // 被观察对象做了更新操作...
        // ....

        // 通知被观察者
        subject.advice();
    }
}
