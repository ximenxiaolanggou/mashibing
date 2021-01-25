package top.damoncai.designattern.singleton;

/**
 * @author zhishun.cai
 * @date 2021/1/21 16:31
 */

/**
 * 跟01是一个意思
 */
public class Mgr02 {
    public static final Mgr02 INSTANCE;

    static {
        INSTANCE = new Mgr02();
    }

    public static Mgr02 getInstance() {
        return INSTANCE;
    }

    private Mgr02() {

    }
}
