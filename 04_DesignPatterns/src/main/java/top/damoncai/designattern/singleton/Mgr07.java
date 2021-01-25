package top.damoncai.designattern.singleton;

/**
 * @author zhishun.cai
 * @date 2021/1/21 16:31
 */
/**
 * 静态内部类方式
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 */
public class Mgr07 {

    private static class Mgr07Holder {
        private final static Mgr07 INSTANCE = new Mgr07();
    }

    public static Mgr07 getInstance() {
        return Mgr07Holder.INSTANCE;
    }

    private Mgr07() {
    }
}
