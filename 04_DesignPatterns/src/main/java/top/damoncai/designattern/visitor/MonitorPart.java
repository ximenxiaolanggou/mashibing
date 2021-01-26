package top.damoncai.designattern.visitor;

import lombok.Data;

/**
 * @author zhishun.cai
 * @date 2021/1/26 17:44
 */

@Data
public class MonitorPart implements ComputerPart{

    double price = 100.0;

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        System.out.println("Monitor ~~");
    }
}
