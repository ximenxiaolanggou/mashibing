package top.damoncai.designattern.state;

/**
 * @author zhishun.cai
 * @date 2021/1/29 14:17
 */

public class Context {

    private State state;

    public Context(){
        state = null;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }


}
