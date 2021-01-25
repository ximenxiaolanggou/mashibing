package top.damoncai.designattern.factorymethod;

/**
 * @author zhishun.cai
 * @date 2021/1/22 14:37
 */

public class Main {

    public static void main(String[] args) {
        Shape shapeCircle = ShapeFactory.getShape(1);
        shapeCircle.draw();
        Shape shapeUnknow = ShapeFactory.getShape(6);
        shapeUnknow.draw();
    }
}
