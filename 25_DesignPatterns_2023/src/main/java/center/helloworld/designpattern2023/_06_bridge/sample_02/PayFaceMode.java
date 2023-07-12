package center.helloworld.designpattern2023._06_bridge.sample_02;

/**
 * @author zhishun.cai
 * @create 2023/7/12
 * @note
 */
public class PayFaceMode implements IPayMode {

    @Override
    public boolean security(String uId) {
        System.out.println("人脸支付,风控校验-脸部识别");
        return true;
    }
}
