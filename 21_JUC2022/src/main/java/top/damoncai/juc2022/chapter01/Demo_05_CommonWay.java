package top.damoncai.juc2022.chapter01;

import lombok.val;

/**
 * 线程的常用方法
 */
public class Demo_05_CommonWay {

    static Object o = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 1.获取当前线程
        Thread currentThread = Thread.currentThread();

        // 2. 设置线程名称
        Thread thread = new Thread(() -> {

        }, "myThread");

        thread.setName("myThread2");

        // 3.设置线程优先级 1-10  默认为5
        thread.setPriority(10);

        // 4.yield 可以通过Thread的静态方法yield，让当前线程从运行状态转变为就绪状态。
        Thread.yield();

        // 5.sleep
        Thread.sleep(1000);

        // 6.join()
        // 不携带参数 等thread线程执行结束再执行
        thread.join();
        // 携带参数 等thread先执行一段时间
        thread.join(2000);

        // 7.守护线程,线程默认为非守护线程
        thread.setDaemon(true);

        // 8.线程的等待和唤醒 实际中红 wait、notify和notifyAll需要放在synchronize中不然会报错
        o.wait();
        o.notify();
        o.notifyAll();

        // 9.stop:结束线程
        thread.stop();

        // 10. interrupted
        thread.interrupt(); // 打断线程
        thread.isInterrupted(); // 获取状态并归为（false）
    }
}
