package top.damoncai.designattern.templatemethod;

/**
 * @author zhishun.cai
 * @date 2021/1/28 21:14
 */

public class SupermaliGame extends  Game{
    @Override
    void start() {
        System.out.println("超级玛丽开始 ~~");
    }

    @Override
    void fight() {
        System.out.println("超级玛丽打妖怪 ~~");
    }

    @Override
    void end() {
        System.out.println("超级玛丽结束 ~~");
    }
}
