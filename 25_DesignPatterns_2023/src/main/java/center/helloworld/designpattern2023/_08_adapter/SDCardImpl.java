package center.helloworld.designpattern2023._08_adapter;

/**
 * @author zhishun.cai
 * @create 2023/7/17
 * @note
 */
public class SDCardImpl implements SDCard{


    @Override
    public String readSD() {
        return "Hello SDCard";
    }

    @Override
    public void writeSD() {
        System.out.println("向SD卡写入数据");
    }
}
