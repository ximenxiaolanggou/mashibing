package top.damoncai.designattern.proxy.staticproxy;

/**
 * @author zhishun.cai
 * @date 2021/1/25 16:02
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Movable planeTimeProxy = new PlaneTimeProxy(new Plane());
        planeTimeProxy.move();
    }
}
