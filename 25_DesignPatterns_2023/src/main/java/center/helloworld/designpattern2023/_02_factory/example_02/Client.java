package center.helloworld.designpattern2023._02_factory.example_02;

/**
 * @author zhishun.cai
 * @create 2023/3/14
 * @note
 */
public class Client {

    public static void main(String[] args) {

        int type = 1;

        FreeFactory freeFactory = FreeGoodsFactoryMap.getParserFactory(type);
        freeFactory.getFreeGoods().sendFreeGoods();

    }
}
