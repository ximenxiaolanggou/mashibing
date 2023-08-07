package center.helloworld.designpattern2023._08_adapter;

/**
 * @author zhishun.cai
 * @create 2023/7/17
 * @note
 */
public interface SDCard {

    /**
     * 读取SD卡信息
     * @return
     */
    public String readSD();


    /**
     * 写SD卡信息
     */
    public void writeSD();
}
