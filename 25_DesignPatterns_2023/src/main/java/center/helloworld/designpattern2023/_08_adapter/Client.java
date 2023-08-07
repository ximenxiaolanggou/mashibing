package center.helloworld.designpattern2023._08_adapter;

/**
 * @author zhishun.cai
 * @create 2023/7/17
 * @note
 */
public class Client {

    public static void main(String[] args) {
        Computer computer = new Computer();
        SDCard sdCard = new SDAdapterTF(new TFCardImpl());
        String res = computer.readSDCard(sdCard);
        System.out.println(res);
    }
}
