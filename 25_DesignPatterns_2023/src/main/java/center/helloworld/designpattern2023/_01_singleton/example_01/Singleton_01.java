package center.helloworld.designpattern2023._01_singleton.example_01;

/**
 * 单例模式 - 饿汉式
 *   通过类加载创建对象，通过jvm来保证单例
 * @author zhishun.cai
 * @create 2023/3/13
 * @note
 */
public class Singleton_01 {

    private static Singleton_01 singleton = new Singleton_01();

    // 构造方法私有化
    private Singleton_01() {

    }


    // 对外提供方法获取单例
    public static Singleton_01 getSingleton() {
        return singleton;
    }
}
