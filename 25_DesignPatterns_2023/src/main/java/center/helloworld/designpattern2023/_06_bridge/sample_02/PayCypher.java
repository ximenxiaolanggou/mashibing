package center.helloworld.designpattern2023._06_bridge.sample_02;

/**
 * @author zhishun.cai
 * @create 2023/7/12
 * @note
 */
//密码支付及风控校验
public class PayCypher implements IPayMode {

    @Override
    public boolean security(String uId) {
        System.out.println("密码支付,风控校验-环境安全");
        return false;
    }
}
