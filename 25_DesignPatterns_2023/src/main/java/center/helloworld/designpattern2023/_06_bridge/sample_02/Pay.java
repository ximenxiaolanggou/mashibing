package center.helloworld.designpattern2023._06_bridge.sample_02;

import java.math.BigDecimal;

/**
 * @author zhishun.cai
 * @create 2023/7/12
 * @note
 */
public abstract class Pay {

    //桥接对象
    protected IPayMode payMode;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    //划账功能
    public abstract String transfer(String uId, String tradeId, BigDecimal amount);

}