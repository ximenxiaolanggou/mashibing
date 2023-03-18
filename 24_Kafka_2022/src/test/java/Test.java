import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zhishun.cai
 * @create 2023/2/28
 * @note
 */
public class Test {

    @org.junit.Test
    public void test() throws ExecutionException, InterruptedException {

        CusCallable cusCallable = new CusCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(cusCallable);
        new Thread(futureTask).start();
        Integer res = futureTask.get();
        System.out.println(res);
    }

    @org.junit.Test
    public void test2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            int i = 0;
           while (!Thread.currentThread().isInterrupted()) {
           }
        });
        t1.start();
        System.out.println(t1.isInterrupted());
        Thread.sleep(500);
        t1.interrupt();
        System.out.println(t1.isInterrupted());
        Thread.sleep(500);

    }
}

class CusCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        return 2000;
    }
}
