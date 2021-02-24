package top.damoncai.designattern.commend;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhishun.cai
 * @date 2021/1/28 13:42
 */

public class Broker {

    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
