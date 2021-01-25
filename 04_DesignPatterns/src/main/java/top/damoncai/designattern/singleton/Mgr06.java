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
 * 第一层null值判断：当实例创建完成就不需走同步代码块
 * 第二层null值判断：线程安全操作
 */
public class Mgr06 {
    public static volatile Mgr06 INSTANCE;


    public static Mgr06 getInstance() {
        if(null == INSTANCE) {
            synchronized (Mgr06.class) {
                if(null == INSTANCE){
                    try {
                        TimeUnit.MICROSECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr06();
                }
            }
        }
        return INSTANCE;
    }

    private Mgr06() {
    }
}
