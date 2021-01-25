package top.damoncai.designattern.singleton;

/**
 * @author zhishun.cai
 * @date 2021/1/21 16:31
 */

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用！
 * 唯一缺点：不管用到与否，类装载时就完成实例化
 * Class.forName("")
 */
public class Mgr01 {
    public static final Mgr01 INSTANCE = new Mgr01();

    public static Mgr01 getInstance() {
        return INSTANCE;
    }

    private Mgr01() {

    }
}
