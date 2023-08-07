package center.helloworld.designpattern2023._09_facade;

/**
 * @author zhishun.cai
 * @create 2023/7/18
 * @note
 */
public class Client {

    public static void main(String[] args) {

        //创建外观对象
        SmartAppliancesFacade facade = new SmartAppliancesFacade();

        facade.say("打开家电");
        facade.say("关闭家电");
    }
}
