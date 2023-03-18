package center.hellowrold.jvm.chapter01;

/**
 * @author zhishun.cai
 * @create 2023/3/16
 * @note
 */
public class Test {

    public static void main(String[] args) {
        ClassLoader classLoader = Test.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());

        classLoader = String.class.getClassLoader();
        System.out.println(classLoader);
    }
}
