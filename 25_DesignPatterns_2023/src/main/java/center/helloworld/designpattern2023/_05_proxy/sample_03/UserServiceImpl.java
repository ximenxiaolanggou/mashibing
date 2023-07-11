package center.helloworld.designpattern2023._05_proxy.sample_03;

import java.util.Collections;
import java.util.List;

/**
 * @author zhishun.cai
 * @create 2023/7/10
 * @note
 */
public class UserServiceImpl {

    public List<User> findUserList(){

        return Collections.singletonList(new User("tom",18));
    }
}

