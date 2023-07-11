package center.helloworld.designpattern2023._05_proxy.sample_01;

/**
 * @author zhishun.cai
 * @create 2023/7/10
 * @note
 */
public class Client {

    public static void main(String[] args) {
        // 创建需要代理的对象
        UserDao userDao = new UserDaoImpl();
        // 创建代理对象
        UserDao userDaoProxy = new UserDaoProxy(userDao);
        // 调用方法
        userDaoProxy.save();
    }
}
