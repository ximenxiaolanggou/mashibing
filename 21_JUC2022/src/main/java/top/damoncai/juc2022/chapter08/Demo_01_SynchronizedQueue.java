package top.damoncai.juc2022.chapter08;

import top.damoncai.juc2022.chapter07.Delay;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

//
public class Demo_01_SynchronizedQueue {

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue queue = new SynchronousQueue();


        String msg = "消息 ！！！";

        new Thread(() -> {
            boolean res = false;
            try {
                res = queue.offer(msg, 1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(res);
        }).start();

        Thread.sleep(100);

        new Thread(() -> {
            Object res = queue.poll();
            System.out.println(res);
        }).start();
    }
}
