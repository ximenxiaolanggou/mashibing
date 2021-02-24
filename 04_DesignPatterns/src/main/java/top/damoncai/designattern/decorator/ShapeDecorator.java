package top.damoncai.designattern.decorator;

/**
 * @author zhishun.cai
 * @date 2021/1/29 14:45
 */

public abstract class ShapeDecorator implements Shape {
    protected  Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    public void draw(){
        shape.draw();
    }
}
