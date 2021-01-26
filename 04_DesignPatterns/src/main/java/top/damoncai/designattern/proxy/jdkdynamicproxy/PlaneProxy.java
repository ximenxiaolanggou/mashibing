package top.damoncai.designattern.proxy.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhishun.cai
 * @date 2021/1/25 17:25
 */

public class PlaneProxy implements InvocationHandler {

    private Movable movable;

    public PlaneProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Start ~~~");
        Object o = method.invoke(movable, args);
        System.out.println("End ~~~");
        return o;
    }
}