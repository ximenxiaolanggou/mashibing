package center.hellowrold.so._01_java_base;

import java.util.Date;

/**
 * 设置标志位控制线程关闭
 */
public class _07_StopThread_SetStopFlag {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(5000);
        // 设置标志位为true,代表关闭线程
        myThread.stopFlag = true;
        System.out.println("main线程结束~~");
    }
}

class MyThread extends Thread {
    // 启停标志位
    boolean stopFlag = false;
    @Override
    public void run() {
        while (!stopFlag) {
            System.out.println(new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("子线程结束~~");
    }
}


