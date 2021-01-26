package top.damoncai.designattern.visitor;

import lombok.Data;

/**
 * @author zhishun.cai
 * @date 2021/1/26 17:44
 */
@Data
public class MousePart implements ComputerPart{

    private double price = 50.0;

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        System.out.println("Mouse ~~");
    }
}
