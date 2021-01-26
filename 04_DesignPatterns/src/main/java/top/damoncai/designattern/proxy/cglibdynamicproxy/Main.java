package top.damoncai.designattern.proxy.cglibdynamicproxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import top.damoncai.designattern.proxy.jdkdynamicproxy.Movable;
import top.damoncai.designattern.proxy.jdkdynamicproxy.PlaneProxy;

import java.lang.reflect.Proxy;

/**
 * @author zhishun.cai
 * @date 2021/1/25 16:02
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Plane.class);
        enhancer.setCallback(new AroundMethodInterceptor());
        Plane plane = (Plane) enhancer.create();
        plane.move();
    }
}
