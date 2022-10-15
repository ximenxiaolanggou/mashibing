package test;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.damoncai.sharding.jdbc.App;
import top.damoncai.sharding.jdbc.entity.Orders;
import top.damoncai.sharding.jdbc.entity.User;
import top.damoncai.sharding.jdbc.mapper.OrdersMapper;
import top.damoncai.sharding.jdbc.mapper.UserMapper;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class OrdersTest {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private UserMapper userMapper;


    /**
     * 水平切分：分库策略
     */
    @Test
    public void add() {
        for (int i = 1; i <=10 ; i++) {
            Orders orders = new Orders();
            orders.setAmount(0.0);
            ordersMapper.insert(orders);
        }
    }

    @Test
    public void test() {
        List<User> users = userMapper.selectList(null);
        users.stream().forEach(System.out::println);
    }
}
