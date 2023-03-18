package center.helloworld.designpattern2023._01_singleton.example_04;

/**
 * 单例模式 - 静态内部类
 *   静态内部类可以保证在使用时才创建对象
 * @author zhishun.cai
 * @create 2023/3/13
 * @note
 */
public class Singleton_04 {

    // 构造方法私有化
    private Singleton_04() {

    }

    public static Singleton_04 getInstance() {
        return SingletonHandler.singleton;
    }

    private static class SingletonHandler {
        private static Singleton_04 singleton = new Singleton_04();
    }
}
