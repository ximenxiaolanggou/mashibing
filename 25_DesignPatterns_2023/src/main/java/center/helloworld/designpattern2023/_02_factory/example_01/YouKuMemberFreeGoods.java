package center.helloworld.designpattern2023._02_factory.example_01;

/**
 * @author zhishun.cai
 * @create 2023/3/14
 * @note
 */
public class YouKuMemberFreeGoods implements IFreeGoods{


    @Override
    public void sendFreeGoods() {
        System.out.println("优酷会员商品活动~~~");
    }
}
