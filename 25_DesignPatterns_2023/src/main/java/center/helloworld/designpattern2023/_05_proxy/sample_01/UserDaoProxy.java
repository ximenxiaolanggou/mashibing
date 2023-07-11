package center.helloworld.designpattern2023._05_proxy.sample_01;

/**
 * @author zhishun.cai
 * @create 2023/7/10
 * @note
 */

/**
 * UserDao代理类
 */
public class UserDaoProxy implements UserDao {

    private UserDao userDao;

    public UserDaoProxy(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void save() {
        System.out.println("代理前做一些事情~~~~");
        userDao.save();
        System.out.println("代理后做一些事情~~~~");
    }

    @Override
    public void update() {
        System.out.println("代理前做一些事情~~~~");
        userDao.update();
        System.out.println("代理后做一些事情~~~~");
    }
}
