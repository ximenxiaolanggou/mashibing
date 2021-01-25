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
 * 和 04一样
 */
public class Mgr05 {
    public static Mgr05 INSTANCE;


    public static Mgr05 getInstance() {
        synchronized (Mgr05.class) {
            if(null == INSTANCE) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Mgr05();
            }
        }
        return INSTANCE;
    }

    private Mgr05() {
    }
}
