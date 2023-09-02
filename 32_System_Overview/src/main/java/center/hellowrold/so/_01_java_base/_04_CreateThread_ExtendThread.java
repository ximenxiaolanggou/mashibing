package center.hellowrold.so._01_java_base;

import java.util.concurrent.Callable;

/**
 * 继承Thread类 创建线程
 */
public class _04_CreateThread_ExtendThread {

    public static void main(String[] args) throws InterruptedException {
        // 继承Thread类 运行方式
        Thread thread1 = new Thread1();
        thread1.start();
        thread1.start();
        Thread.sleep(10);
    }

}

// 继承Thread类
class Thread1 extends Thread {

    @Override
    public void run() {
        System.out.println("Thread1");
    }
}


