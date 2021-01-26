package top.damoncai.designattern.proxy.jdkdynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @author zhishun.cai
 * @date 2021/1/25 16:02
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Movable plane = new Plane();
        //参数一：被代理对象的类加载器
        //参数二：获取被代理的接口集合
        //参数三：InvocationHandler实现类 最终用就是改用该类的invoke方法实现代理
        Movable proxy = (Movable) Proxy.newProxyInstance(Plane.class.getClassLoader(), Plane.class.getInterfaces(), new PlaneProxy(plane));
        proxy.move();
    }
}
