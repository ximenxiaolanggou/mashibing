package top.damoncai.designattern.decorator;

/**
 * @author zhishun.cai
 * @date 2021/1/29 14:43
 */

public class RectangleShape implements Shape {


    @Override
    public void draw() {
        System.out.println("画方块 ~~");
    }
}
