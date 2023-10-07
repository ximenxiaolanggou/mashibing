package center.helloworld.juc2023._01_CreateThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callabel - 创建线程
 */
public class Demo_03_Callable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task = new FutureTask(new MyCallable());
        Thread t1 = new Thread(task);
        t1.start();
        // 做一些其他业务

        // get会阻塞
        Object res = task.get();
        System.out.println(res);
    }
}

class MyCallable implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}
