package center.hellowrold.jvm.chapter04;

import java.lang.reflect.Constructor;

/**
 * @author zhishun.cai
 * @create 2023/3/30
 * @note
 */
public class SampleTest {

    public static void main(String[] args) throws ClassNotFoundException {
        String a = "";
        System.out.println("hello");

        Class<?> zClass = Class.forName("center.hellowrold.jvm.chapter04.SampleTest");
        Constructor<?>[] constructors = zClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getParameterTypes());
        }
    }

    public void sayHello() throws ClassNotFoundException {

    }
}
