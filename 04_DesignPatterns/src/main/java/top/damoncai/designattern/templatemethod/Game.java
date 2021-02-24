package top.damoncai.designattern.templatemethod;

/**
 * @author zhishun.cai
 * @date 2021/1/28 21:12
 */

public abstract class Game {

    abstract void start();

    abstract void fight();

    abstract void end();

    public void play() {
        start();
        fight();
        end();
    }
}
