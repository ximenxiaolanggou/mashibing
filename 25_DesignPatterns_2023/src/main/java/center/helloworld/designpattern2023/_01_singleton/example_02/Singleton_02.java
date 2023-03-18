package center.helloworld.designpattern2023._01_singleton.example_02;

/**
 * 单例模式 - 懒汉式
 *   只有在获取对象时才创建对象，但是多线程下有问题，所以需要自己来保证线程安全
 * @author zhishun.cai
 * @create 2023/3/13
 * @note
 */
public class Singleton_02 {

    private static Singleton_02 singleton;

    // 构造方法私有化
    private Singleton_02() {

    }


    // 对外提供方法获取单例
    public static synchronized Singleton_02 getSingleton() {
        if(singleton == null)
            singleton = new Singleton_02();
        return singleton;
    }
}
