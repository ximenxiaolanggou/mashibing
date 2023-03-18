package center.helloworld.designpattern2023._02_factory.example_01;

/**
 * @author zhishun.cai
 * @create 2023/3/14
 * @note
 */
public class FreeFactory {

    private static IFreeGoods iFreeGoods;

    public static IFreeGoods getFreeGoods(Integer type) {
        if(type == 1)
            iFreeGoods = new DiscountFreeGoods();
        else if(type == 2)
            iFreeGoods = new SmallGiftFreeGoods();
        else if(type == 3)
            iFreeGoods = new YouKuMemberFreeGoods();

        return iFreeGoods;
    }
}
