package center.helloworld.designpattern2023._06_bridge.sample_02;

/**
 * @author zhishun.cai
 * @create 2023/7/12
 * @note
 */
public class PayFingerprintMode implements IPayMode {

    @Override
    public boolean security(String uId) {
        System.out.println("指纹支付,风控校验-指纹信息");
        return true;
    }
}