package top.damoncai.designattern.singleton;

import java.util.concurrent.TimeUnit;

/**
 * @author zhishun.cai
 * @date 2021/1/21 16:31
 */

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * 可以通过synchronized解决，但也带来效率下降
 */
public class Mgr04 {
    public static Mgr04 INSTANCE;


    public static synchronized Mgr04 getInstance() {
        if(null == INSTANCE) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }

    private Mgr04() {
    }
}
