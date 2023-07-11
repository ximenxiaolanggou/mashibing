package center.helloworld.designpattern2023._05_proxy.sample_02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhishun.cai
 * @create 2023/7/10
 * @note 代理工厂
 */

/**
 * 创建代理工厂
 */
public class ProxyFactory {

    private Object o;

    public ProxyFactory(Object o) {
        this.o = o;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(
                // 代理对象的类加载器
                o.getClass().getClassLoader(),
                // 代理对象实现的接口
                o.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理前干些事情~~~");
                        System.out.println("执行：" + method.getName() + " 方法");
                        method.invoke(o, args);
                        System.out.println("代理后干些事情~~~");
                        return null;
            }
        });
    }
}
