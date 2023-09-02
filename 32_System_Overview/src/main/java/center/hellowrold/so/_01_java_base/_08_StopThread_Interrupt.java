package center.hellowrold.so._01_java_base;

import java.util.Date;

/**
 * interrupt 打断线程
 */
public class _08_StopThread_Interrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new MyThreadInterrupt();
        t1.start();
        Thread.sleep(3000);
        t1.interrupt(); // 中断线程 将中断标志由false修改为了true
        // t1.stop(); // 直接就把线程给kill掉了
        System.out.println("main .... ");
    }
}

class MyThreadInterrupt extends Thread {
    @Override
    public void run() {
        System.out.println(this.getName() + " start...");
        int i = 0 ;
        // Thread.interrupted() 如果没有被中断 那么是false 如果显示的执行了interrupt 方法就会修改为 true
        while(!Thread.interrupted()){
            System.out.println(this.getName() + " " + i);
            i++;
        }

        System.out.println(this.getName()+ " end .... ");
    }
}

