package center.helloworld.designpattern2023._08_adapter;

/**
 * @author zhishun.cai
 * @create 2023/7/17
 * @note
 */
public class Computer {

    public String readSDCard(SDCard sdCard) {
        return sdCard.readSD();
    }
}
