package center.helloworld.designpattern2023._08_adapter;

/**
 * @author zhishun.cai
 * @create 2023/7/17
 * @note
 */
public interface TFCard {

    /**
     * 读取TF卡信息
     * @return
     */
    public String readTF();


    /**
     * 写TF卡信息
     */
    public void writeTF();
}
