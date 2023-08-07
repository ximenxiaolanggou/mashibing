package center.helloworld.designpattern2023._08_adapter;

/**
 * @author zhishun.cai
 * @create 2023/7/17
 * @note
 */
public class TFCardImpl implements TFCard{
    @Override
    public String readTF() {
        return "Hello TFCard";
    }

    @Override
    public void writeTF() {
        System.out.println("TF Card 写入信息");
    }
}
