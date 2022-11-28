package top.damoncai.juc2022.chapter09;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// newSingleThreadPool 单个线程数
public class Demo_02_newSingleThreadPool {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newSingleThreadExecutor();


        threadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + ": 111111" );
        });

        threadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + ": 222222" );
        });

        threadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + ": 333333" );
        });
    }
}
