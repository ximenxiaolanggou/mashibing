package top.damoncai.designattern.factorymethod;

/**
 * @author zhishun.cai
 * @date 2021/1/22 14:34
 */

public class ShapeFactory {

    public static Shape getShape(int type){
        Shape shape = null;
        switch (type) {
            case 1:
                shape = new Circle();
                break;
            case 2:
                shape = new Square();
                break;
            case 3:
                shape = new Rectangle();
                break;
            default:
                throw new RuntimeException("未知类型: " + type);
        }
        return shape;
    }
}
