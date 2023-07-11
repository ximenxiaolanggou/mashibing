package center.helloworld.designpattern2023._05_proxy.sample_02;

import center.helloworld.designpattern2023._05_proxy.sample_01.UserDao;
import center.helloworld.designpattern2023._05_proxy.sample_01.UserDaoImpl;
import center.helloworld.designpattern2023._05_proxy.sample_01.UserDaoProxy;

/**
 * @author zhishun.cai
 * @create 2023/7/10
 * @note
 */
public class Client {

    public static void main(String[] args) {
        // 创建需要代理的目标对象
        UserDao userDao = new UserDaoImpl();
        // 创建代理对象
        UserDao proxy = (UserDao)new ProxyFactory(userDao).getProxy();
        // 调用方法
        proxy.save();
    }
}
