package top.damoncai.designattern.visitor;

/**
 * @author zhishun.cai
 * @date 2021/1/26 17:43
 * @note
 */

public interface ComputerPartVisitor {

    double visitMonitor(MonitorPart monitorPart);

    double visitMouse(MousePart mousePart);

}
