package center.helloworld.designpattern2023._02_factory.example_02;

/**
 * @author zhishun.cai
 * @create 2023/3/14
 * @note
 */
public class SmallGiftFreeGoods implements IFreeGoods {


    @Override
    public void sendFreeGoods() {
        System.out.println("免费小礼物商品活动~~~");
    }
}
