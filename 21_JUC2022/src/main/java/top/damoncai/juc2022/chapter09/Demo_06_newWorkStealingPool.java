package top.damoncai.juc2022.chapter09;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * newScheduledThreadPool
 */
public class Demo_06_newWorkStealingPool {

    private static int E_NUM = 1_000_000_000;

    private static int datas[] = new int[E_NUM];

    static {
        for (int i = 0; i < E_NUM; i++) {
            datas[i] = (int)(Math.random() * 1000);
        }
    }

    public static void main(String[] args) throws Exception {

        // 单线程计算10亿数据

        System.out.println("单线程计算开始");
        long begin = System.currentTimeMillis();
        long sum = 0;
        for (int data : datas) {
            sum += data;
        }
        System.out.println("单线程计结束，耗时：" + (System.currentTimeMillis() - begin) + ", 结果值为: " + sum);

    }
}
