package center.hellowrold.spring2024.chapter02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhishun.cai
 * @create 2024/4/30
 * @note
 */
public class Subject {

    public static void main(String[] args) {
        Animal cat = new Cat();
        ClassLoader classLoader = Animal.class.getClassLoader();
        Animal animal = (Animal) Proxy.newProxyInstance(classLoader, new Class[]{Animal.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before ~~");
                Object res = method.invoke(cat, args);
                System.out.println("after ~~");
                return res;
            }
        });

        animal.food();
    }
}
