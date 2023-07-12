package center.helloworld.designpattern2023._06_bridge.sample_02;

/**
 * @author zhishun.cai
 * @create 2023/7/12
 * @note 支付模式接口
 */
public interface IPayMode {

    //安全校验功能: 对各种支付模式进行风控校验
    boolean security(String uId);
}
