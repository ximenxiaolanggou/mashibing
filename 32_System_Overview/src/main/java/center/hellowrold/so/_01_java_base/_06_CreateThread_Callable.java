package center.hellowrold.so._01_java_base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现callable接口创建线程方式
 */
public class _06_CreateThread_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建一个Callable实例
        Callable<Integer> callable = new Thread3();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        // 获取一个线程 肯定是要先创建一个Thread对象  futureTask本质上是Runable接口的实现
        Thread t1 = new Thread(futureTask);
        System.out.println("main方法start....");
        t1.start(); // 本质还是执行的 Runable中的run方法，只是 run方法调用了call方法罢了
        // 获取返回的结果
        System.out.println(futureTask.get()); // 获取开启的线程执行完成后返回的结果
        System.out.println("main方法end ....");
    }
}

// 实现callable接口
class Thread3 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Thread3");
        return 1;
    }
}