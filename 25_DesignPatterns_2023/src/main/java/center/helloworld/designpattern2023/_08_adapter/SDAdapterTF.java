package center.helloworld.designpattern2023._08_adapter;

/**
 * @author zhishun.cai
 * @create 2023/7/17
 * @note
 */
public class SDAdapterTF implements SDCard{

    private TFCard tfCard;

    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        return tfCard.readTF();
    }

    @Override
    public void writeSD() {
        tfCard.writeTF();
    }
}
