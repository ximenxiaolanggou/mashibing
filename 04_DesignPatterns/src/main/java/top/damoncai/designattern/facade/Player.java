package top.damoncai.designattern.facade;

/**
 * @author zhishun.cai
 * @date 2021/1/29 15:02
 */

/**
 * 播放器
 */
public class Player {
    public void on() {
        System.out.println("播放器\t打开");
    }
    public void off() {
        System.out.println("播放器\t关闭");
    }
    public void play() {
        System.out.println("播放器\t播放");
    }
    public void pause() {
        System.out.println("播放器\t暂停");
    }
}
