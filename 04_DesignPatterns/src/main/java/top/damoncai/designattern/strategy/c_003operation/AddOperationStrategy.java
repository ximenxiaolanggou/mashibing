package top.damoncai.designattern.strategy.c_003operation;

/**
 * @author zhishun.cai
 * @date 2021/1/22 11:56
 */

public class AddOperationStrategy implements OperationStrategy {
    @Override
    public int operation(int a, int b) {
        return a + b;
    }
}
