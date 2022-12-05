package top.damoncai.juc2022.chapter11;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Demo_01_CountDownLatch {

    static ThreadPoolExecutor executors = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
    static CountDownLatch countDownLatch = new CountDownLatch(3);

    /**
     * countDownLatch
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        executors.execute(Demo_01_CountDownLatch::a);
        executors.execute(Demo_01_CountDownLatch::b);
        executors.execute(Demo_01_CountDownLatch::c);

        countDownLatch.await();
        System.out.println("任务执行完成");
        executors.shutdown();

    }

    private static void a(){
        System.out.println("任务A开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务A结束");
        countDownLatch.countDown();
    }

    private static void b() {
        System.out.println("任务B开始");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务B结束");
        countDownLatch.countDown();
    }

    private static void c(){
        System.out.println("任务C开始");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务C结束");
        countDownLatch.countDown();
    }
}
