package center.helloworld.designpattern2023._01_singleton.example_03;

/**
 * 单例模式 - 懒汉式（DCL）
 *   只有在获取对象时才创建对象，但是多线程下有问题，所以需要自己来保证线程安全
 * @author zhishun.cai
 * @create 2023/3/13
 * @note
 */
public class Singleton_03 {

    private static Singleton_03 singleton;

    // 构造方法私有化
    private Singleton_03() {

    }


    // 对外提供方法获取单例
    public static Singleton_03 getSingleton() {

        if(singleton == null) {
            synchronized (Singleton_03.class) {
                // 防止除第一个线程以外进来，创建对象
                if(singleton == null)
                    singleton = new Singleton_03();
            }
        }
        return singleton;
    }
}
