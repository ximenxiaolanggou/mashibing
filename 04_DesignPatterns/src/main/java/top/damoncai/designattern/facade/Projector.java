package top.damoncai.designattern.facade;

/**
 * @author zhishun.cai
 * @date 2021/1/29 15:03
 */

/**
 * 投影仪
 */
public class Projector {
    public void on() {
        System.out.println("投影仪\t打开");
    }
    public void focus() {
        System.out.println("投影仪\t校正");
    }
    public void off() {
        System.out.println("投影仪\t关闭");
    }
}
