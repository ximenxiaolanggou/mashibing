package top.damoncai.designattern.commend;

/**
 * @author zhishun.cai
 * @date 2021/1/28 13:38
 */

public class SellStock implements Order {

    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}
