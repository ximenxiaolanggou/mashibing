package top.damoncai.designattern.proxy.jdkdynamicproxy;

/**
 * @author zhishun.cai
 * @date 2021/1/25 15:57
 */

public class Plane implements Movable {
    @Override
    public void move() {
        System.out.println("Fly ~~");
    }
}
