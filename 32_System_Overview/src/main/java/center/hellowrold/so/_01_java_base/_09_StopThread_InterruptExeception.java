package center.hellowrold.so._01_java_base;

import java.util.Date;

/**
 * interruptExeception 打断线程
 */
public class _09_StopThread_InterruptExeception {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new MyThreadInterruptExeception();
        t1.start();
        Thread.sleep(3000);
        t1.interrupt(); // 中断线程 将中断标志由false修改为了true
        System.out.println("main .... ");
    }
}

class MyThreadInterruptExeception extends Thread {
    @Override
    public void run() {
        // Thread.interrupted() 如果没有被中断 那么是false 如果显示的执行了interrupt 方法就会修改为 true
        while(!Thread.interrupted()){
            System.out.println(new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                // 当线程处于sleep状态时，被打断会抛出InterruptedException异常信息
                break;
            }
        }
        System.out.println(this.getName()+ " end .... ");
    }
}

