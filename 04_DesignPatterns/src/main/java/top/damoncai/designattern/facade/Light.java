package top.damoncai.designattern.facade;

/**
 * @author zhishun.cai
 * @date 2021/1/29 15:02
 */

/**
 * 灯光
 */
public class Light {
    public void on() {
        System.out.println("灯光\t打开");
    }
    public void off() {
        System.out.println("灯光\t关闭");
    }
    public void faint() {
        System.out.println("灯光\t微光");
    }
}
