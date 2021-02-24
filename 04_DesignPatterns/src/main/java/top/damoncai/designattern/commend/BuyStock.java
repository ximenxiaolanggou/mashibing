package top.damoncai.designattern.commend;

/**
 * @author zhishun.cai
 * @date 2021/1/28 13:38
 */

public class BuyStock implements Order {

    private Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}
