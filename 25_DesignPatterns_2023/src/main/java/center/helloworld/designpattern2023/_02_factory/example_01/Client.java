package center.helloworld.designpattern2023._02_factory.example_01;

/**
 * @author zhishun.cai
 * @create 2023/3/14
 * @note
 */
public class Client {

    public static void main(String[] args) {
        IFreeGoods freeGoods = null;

        freeGoods = FreeFactory.getFreeGoods(1);
        freeGoods.sendFreeGoods();

        freeGoods = FreeFactory.getFreeGoods(2);
        freeGoods.sendFreeGoods();

        freeGoods = FreeFactory.getFreeGoods(3);
        freeGoods.sendFreeGoods();

    }
}
