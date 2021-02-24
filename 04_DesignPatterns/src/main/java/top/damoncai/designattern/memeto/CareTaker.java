package top.damoncai.designattern.memeto;

/**
 * @author zhishun.cai
 * @date 2021/1/28 17:37
 */

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}
