package top.damoncai.juc2022.chapter02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 指令重排序
 */
public class Demo_10_Instruction_Reorder_Demo {

    static int a,b,x,y;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            a = 0;
            b = 0;
            x = 0;
            y = 0;

            Thread t1 = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;
            });

            t1.start();
            t2.start();
            t1.join();
            t2.join();

            if(x == 0 && y == 0){
                System.out.println("第" + i + "次，x = "+ x + ",y = " + y);
            }
        }
    }
}
