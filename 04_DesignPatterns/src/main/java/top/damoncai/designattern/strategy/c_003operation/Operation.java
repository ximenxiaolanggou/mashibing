package top.damoncai.designattern.strategy.c_003operation;

/**
 * @author zhishun.cai
 * @date 2021/1/22 11:58
 */

public class Operation {

    public int operation(int a, int b, OperationStrategy operationStrategy){
        return operationStrategy.operation(a,b);
    }
}
