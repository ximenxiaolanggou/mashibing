package top.damoncai.juc.c_026_01_ThreadPool;

import java.util.concurrent.*;

/**
 * @author zhishun.cai
 * @date 2020/12/21 12:41
 */

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService e = Executors.newSingleThreadExecutor();
        Future<String> submit = e.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "123";
            }
        });
        System.out.println("main");
        String s = submit.get();
        System.out.println(s);
        e.shutdownNow();
    }
}
