package top.damoncai.designattern.memeto;

/**
 * @author zhishun.cai
 * @date 2021/1/28 17:21
 */

public class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}
