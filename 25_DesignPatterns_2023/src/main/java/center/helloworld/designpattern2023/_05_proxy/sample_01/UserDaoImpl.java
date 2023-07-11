package center.helloworld.designpattern2023._05_proxy.sample_01;

/**
 * @author zhishun.cai
 * @create 2023/7/10
 * @note
 */

/**
 * UserDao实现类
 */
public class UserDaoImpl implements UserDao{
    @Override
    public void save() {
        System.out.println("保存用户~~");
    }

    @Override
    public void update() {
        System.out.println("更新用户~~");
    }
}
