package center.helloworld.jdk.chapter_06_Jdk_17;

/**
 * @author zhishun.cai
 * @create 2023/8/10
 * @note switch 模式匹配
 */
public class Demo_01_Match {

    public static void main(String[] args) {
        A a = new B();
        switch (a) {
            case B b -> System.out.println("b");
            case C c -> System.out.println("C");
            case D d -> System.out.println("d");
            default -> System.out.println("Default");
        }
    }
}

class A {}
class B extends A {}
class C extends A {}
class D extends A {}