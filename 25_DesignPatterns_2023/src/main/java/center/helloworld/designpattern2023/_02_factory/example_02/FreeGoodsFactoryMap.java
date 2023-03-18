package center.helloworld.designpattern2023._02_factory.example_02;

import java.util.HashMap;
import java.util.Map;
import java.util.zip.DataFormatException;

/**
 * @author zhishun.cai
 * @create 2023/3/14
 * @note
 */
public class FreeGoodsFactoryMap {

    private static final Map<Integer, FreeFactory> factorys = new HashMap();


    static {
        factorys.put(1, new DiscountFreeGoodsFactory());
        factorys.put(2, new SmallGiftFreeGoodsFactory());
    }

    public static FreeFactory getParserFactory(Integer type) {
        return factorys.get(type);
    }
}
