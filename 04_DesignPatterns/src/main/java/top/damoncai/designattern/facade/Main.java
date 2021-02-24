package top.damoncai.designattern.facade;

/**
 * @author zhishun.cai
 * @date 2021/1/29 15:04
 */

public class Main {
    public static void main(String[] args) {
        HomeTheatre theatre = new HomeTheatre();
        System.out.println("--- 准备播放 ---");
        theatre.ready();
        System.out.println("--- 开始播放 ---");
        theatre.play();
        System.out.println("--- 暂停播放 ---");
        theatre.pause();
        System.out.println("--- 继续播放 ---");
        theatre.play();
        System.out.println("--- 关闭播放 ---");
        theatre.end();
    }
}
