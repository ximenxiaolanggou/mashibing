package top.damoncai.designattern.abstractfactory.c002_shape;

/**
 * @author zhishun.cai
 * @date 2021/1/22 15:23
 */

public class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
