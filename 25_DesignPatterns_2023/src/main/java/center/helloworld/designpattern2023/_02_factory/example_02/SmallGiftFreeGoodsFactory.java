package center.helloworld.designpattern2023._02_factory.example_02;

/**
 * @author zhishun.cai
 * @create 2023/3/14
 * @note
 */
public class SmallGiftFreeGoodsFactory implements FreeFactory{
    @Override
    public IFreeGoods getFreeGoods() {
        return new SmallGiftFreeGoods();
    }
}
