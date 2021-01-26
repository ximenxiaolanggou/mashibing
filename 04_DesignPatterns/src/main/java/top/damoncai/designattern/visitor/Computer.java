package top.damoncai.designattern.visitor;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhishun.cai
 * @date 2021/1/26 17:46
 */

public class Computer implements ComputerPart {

    MonitorPart monitorPart;

    MousePart mousePart;

    public Computer() {
        monitorPart = new MonitorPart();
        mousePart = new MousePart();
    }


    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {

        double v = computerPartVisitor.visitMonitor(monitorPart);
        double v1 = computerPartVisitor.visitMouse(mousePart);
        System.out.println("sum：" + (v + v1));
    }
}
