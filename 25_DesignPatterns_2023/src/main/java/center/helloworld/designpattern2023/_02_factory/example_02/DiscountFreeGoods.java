package center.helloworld.designpattern2023._02_factory.example_02;

/**
 * @author zhishun.cai
 * @create 2023/3/14
 * @note
 */
public class DiscountFreeGoods implements IFreeGoods {


    @Override
    public void sendFreeGoods() {
        System.out.println("打折商品活动~~~");
    }
}
