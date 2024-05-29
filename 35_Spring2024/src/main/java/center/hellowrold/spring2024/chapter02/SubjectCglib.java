package center.hellowrold.spring2024.chapter02;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhishun.cai
 * @create 2024/4/30
 * @note
 */
public class SubjectCglib {

    public static void main(String[] args) {
        Cat cat = new Cat();
        Cat c = (Cat) Enhancer.create(Cat.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("before ~~");
                Object res = methodProxy.invokeSuper(o, args);
                System.out.println("after ~~");
                return res;
            }
        });

        c.food();
    }
}
