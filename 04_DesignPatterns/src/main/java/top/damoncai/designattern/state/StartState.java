package top.damoncai.designattern.state;

/**
 * @author zhishun.cai
 * @date 2021/1/29 14:17
 */

public class StartState implements State {



    @Override
    public void doAction(Context context) {
        System.out.println("启动状态");
        context.setState(this);
    }
}
