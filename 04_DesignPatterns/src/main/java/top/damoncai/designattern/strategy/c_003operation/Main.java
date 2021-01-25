package top.damoncai.designattern.strategy.c_003operation;

/**
 * @author zhishun.cai
 * @date 2021/1/22 13:33
 */

public class Main {

    public static void main(String[] args) {
        Operation operation = new Operation();
        int res1 = operation.operation(1, 2, new AddOperationStrategy());
        int res2 = operation.operation(1, 2, new MultiplyOperationStrategy());
        System.out.println(res1);
        System.out.println(res2);
    }
}
