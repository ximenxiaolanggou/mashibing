package top.damoncai.juc2022.chapter09;

import java.util.concurrent.*;

// newFixedThreadPool固定线程个数
public class Demo_01_newFixedThreadPool {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        threadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        threadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        threadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });

    }
}
