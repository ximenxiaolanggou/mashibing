package center.helloworld.jdk.entity;

/**
 * @author zhishun.cai
 * @create 2023/8/9
 * @note
 */
public interface UserInterface {

    /**
     * 静态方法
     */
    static void staticMethod() {

    }

    /**
     * 默认方法
     */
    default void defaultMethod() {

    }

    /**
     * 私有方法
     */
    private void privateMethod() {

    }
}
