package top.damoncai.designattern.facade;

/**
 * @author zhishun.cai
 * @date 2021/1/29 15:03
 */

/**
 * 家庭影院（外观类）
 */
public class HomeTheatre {
    private Light light;
    private Player player;
    private Projector projector;
    public void ready() {
        projector.on();
        player.on();
        projector.focus();
    }
    public void play() {
        light.off();
        player.play();
    }
    public void pause() {
        light.faint();
        player.pause();
    }
    public void end() {
        light.on();
        player.off();
        projector.off();;
    }
    public HomeTheatre() {
        light = new Light();
        player = new Player();
        projector = new Projector();
    }
}
