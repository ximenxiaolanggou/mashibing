package top.damoncai.juc2022.chapter11;

import java.util.concurrent.CyclicBarrier;

public class Demo_02_CyclicBarrier {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(3,() -> {
            System.out.println("等到各位大佬都到位之后，分发护照和签证等内容！");
        });

        new Thread(() -> {
            System.out.println("Tom到位！！！");
            try {
                barrier.await();
            } catch (Exception e) {
                System.out.println("悲剧，人没到齐！");
                return;
            }
            System.out.println("Tom出发！！！");
        }).start();
        Thread.sleep(100);
        new Thread(() -> {
            System.out.println("Jack到位！！！");
            try {
                barrier.await();
            } catch (Exception e) {
                System.out.println("悲剧，人没到齐！");
                return;
            }
            System.out.println("Jack出发！！！");
        }).start();
        Thread.sleep(100);
        new Thread(() -> {
            System.out.println("Rose到位！！！");
            try {
                barrier.await();
            } catch (Exception e) {
                System.out.println("悲剧，人没到齐！");
                return;
            }
            System.out.println("Rose出发！！！");
        }).start();
    /*
    tom到位，jack到位，rose到位
    导游发签证
    tom出发，jack出发，rose出发
     */

    }
}
