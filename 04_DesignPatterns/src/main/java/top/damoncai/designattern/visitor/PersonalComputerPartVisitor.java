package top.damoncai.designattern.visitor;

import lombok.Data;

/**
 * @author zhishun.cai
 * @date 2021/1/26 17:49
 */

@Data
public class PersonalComputerPartVisitor implements ComputerPartVisitor {

    double sum;

    double monitorDis = 0.8;

    double mouseDis = 0.8;
    @Override
    public double visitMonitor(MonitorPart monitorPart) {
        return sum += monitorPart.getPrice() * monitorDis;
    }

    @Override
    public double visitMouse(MousePart mousePart) {
        return sum += mousePart.getPrice() * mouseDis;
    }
}
