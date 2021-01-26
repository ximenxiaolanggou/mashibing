package top.damoncai.designattern.proxy.cglibdynamicproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhishun.cai
 * @date 2021/1/25 18:08
 */

public class AroundMethodInterceptor implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(o.getClass().getSuperclass().getName());
        before();
        Object res = methodProxy.invokeSuper(o, objects);
        after();
        return res;
    }

    public void before() {
        System.out.println("Before ~~~");
    }

    public void after() {
        System.out.println("After ~~~");
    }
}
