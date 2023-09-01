package center.hellowrold.so._01_java_base;

import org.junit.Test;

/**
 * @author zhishun.cai
 * @create 2023/9/1
 * @note 内部类
 */
public class _02_InnerClass {
    public static void main(String[] args) {
        new OuterClass() {

        };
    }

    // 成员内部类 public static private 都可以修饰类
    class FieldClass {

    }

    // 静态内部类
    static class StaticClass {

    }

    public void sayHello() {
        // 成员内部类 public static private 不可以修饰
        class MemberClass {

        }
    }
}

class OuterClass {
    static String name = "";
}
