package top.damoncai.designattern.state;

/**
 * @author zhishun.cai
 * @date 2021/1/29 14:17
 */

public class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("停止状态");
        context.setState(this);
    }
}
