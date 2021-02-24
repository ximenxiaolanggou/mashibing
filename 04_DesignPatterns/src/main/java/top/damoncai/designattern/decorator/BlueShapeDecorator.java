package top.damoncai.designattern.decorator;

/**
 * @author zhishun.cai
 * @date 2021/1/29 14:47
 */

public class BlueShapeDecorator extends ShapeDecorator  {

    public BlueShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        setRedBorder(shape);
    }

    private void setRedBorder(Shape shape){
        System.out.println("Border Color: Blue");
    }
}
