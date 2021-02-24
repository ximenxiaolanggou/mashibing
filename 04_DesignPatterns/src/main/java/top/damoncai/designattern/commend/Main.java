package top.damoncai.designattern.commend;

/**
 * @author zhishun.cai
 * @date 2021/1/28 13:40
 */

public class Main {

    public static void main(String[] args) {

        // 创建 命令发布者 invoke
        Broker broker = new Broker();

        //创建命令执行对象
        Stock stock = new Stock();

        //创建命令
        Order buyOrder = new BuyStock(stock);
        Order sellOrder = new SellStock(stock);


        //执行
        broker.takeOrder(buyOrder);
        broker.takeOrder(sellOrder);

        broker.placeOrders();
    }
}
