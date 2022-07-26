package top.damoncai.juc2022.chapter01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程方式三：实现callable方法
 */
public class Demo_03_CreateThread_03 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1.创建线程
        MyCallable myCallable = new MyCallable();
        // 2.创建FutureTask
        FutureTask futureTask = new FutureTask(myCallable);
        // 3.创建线程
        Thread thread = new Thread(futureTask);
        // 4.启动任务
        thread.start();
        // 5.做些其他事
        // 6.索要结果
        Object count = futureTask.get();
        System.out.println("总和:" + count);
    }
}

class MyCallable implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}