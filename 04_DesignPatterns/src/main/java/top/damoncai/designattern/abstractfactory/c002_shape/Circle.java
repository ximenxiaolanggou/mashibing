package top.damoncai.designattern.abstractfactory.c002_shape;

/**
 * @author zhishun.cai
 * @date 2021/1/22 15:22
 */

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
