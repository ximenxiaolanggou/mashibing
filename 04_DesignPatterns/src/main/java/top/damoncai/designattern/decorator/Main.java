package top.damoncai.designattern.decorator;

/**
 * @author zhishun.cai
 * @date 2021/1/29 14:49
 */

public class Main {

    public static void main(String[] args) {
        Shape circle = new CircleShape();
        ShapeDecorator redCircle = new RedShapeDecorator(new CircleShape());
        ShapeDecorator redRectangle = new RedShapeDecorator(new RectangleShape());
        //Shape redCircle = new RedShapeDecorator(new Circle());
        //Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
