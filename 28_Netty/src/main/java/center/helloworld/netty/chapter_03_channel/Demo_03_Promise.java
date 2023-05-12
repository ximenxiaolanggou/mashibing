package center.helloworld.netty.chapter_03_channel;

import io.netty.channel.DefaultEventLoop;
import io.netty.util.concurrent.DefaultPromise;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @author zhishun.cai
 * @create 2023/5/12
 * @note promise
 */
public class Demo_03_Promise {

    /**
     * 同步处理任务成功
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void demo1() throws ExecutionException, InterruptedException {
        DefaultEventLoop eventExecutors = new DefaultEventLoop();
        DefaultPromise<Integer> promise = new DefaultPromise<>(eventExecutors);

        eventExecutors.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("set success, 10");
            promise.setSuccess(10);
        });
        System.out.println("start");
        System.out.println(promise.getNow());// 还没有结果
        System.out.println(promise.get());
    }

    /**
     * 异步处理任务成功
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void demo2() throws ExecutionException, InterruptedException, IOException {
        DefaultEventLoop eventExecutors = new DefaultEventLoop();
        DefaultPromise<Integer> promise = new DefaultPromise<>(eventExecutors);

        // 设置回调，异步接收结果
        promise.addListener(future -> {
            // 这里的 future 就是上面的 promise
            System.out.println(future.getNow());
        });

        eventExecutors.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("set success, 10");
            promise.setSuccess(10);
        });
        System.out.println("start");

        System.in.read();
    }

    /**
     * 同步处理任务失败 - sync & get
     */
    @Test
    public void demo3() throws ExecutionException, InterruptedException, IOException {

        DefaultEventLoop eventExecutors = new DefaultEventLoop();
        DefaultPromise<Integer> promise = new DefaultPromise<>(eventExecutors);

        eventExecutors.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            RuntimeException e = new RuntimeException("error...");
            System.out.println("set failure msg");
            promise.setFailure(e);
        });

        System.out.println("start");
        System.out.println(promise.getNow());// 还没有结果
        System.out.println(promise.get()); // sync() 也会出现异常，只是 get 会再用 ExecutionException 包一层异常
        System.in.read();
    }

    /**
     * 同步处理任务失败 - await
     */
    @Test
    public void demo4() throws ExecutionException, InterruptedException, IOException {

        DefaultEventLoop eventExecutors = new DefaultEventLoop();
        DefaultPromise<Integer> promise = new DefaultPromise<>(eventExecutors);

        eventExecutors.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            RuntimeException e = new RuntimeException("error...");
            System.out.println("set failure msg");
            promise.setFailure(e);
        });

        System.out.println("start");
        System.out.println(promise.getNow());// 还没有结果
        promise.await(); // 与 sync 和 get 区别在于，不会抛异常

        System.out.println("result -> " + (promise.isSuccess() ? promise.getNow() : promise.cause()).toString());
        System.in.read();
    }


    /**
     * 异步处理任务失败
     */
    @Test
    public void demo5() throws ExecutionException, InterruptedException, IOException {

        DefaultEventLoop eventExecutors = new DefaultEventLoop();
        DefaultPromise<Integer> promise = new DefaultPromise<>(eventExecutors);

        promise.addListener(future -> {
            System.out.println("result -> " + (promise.isSuccess() ? promise.getNow() : promise.cause()).toString());
        });

        eventExecutors.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            RuntimeException e = new RuntimeException("error...");
            System.out.println("set failure msg");
            promise.setFailure(e);
        });

        System.in.read();
    }

    /**
     * await 死锁检查
     */
    @Test
    public void demo6() throws IOException {
        DefaultEventLoop eventExecutors = new DefaultEventLoop();
        DefaultPromise<Integer> promise = new DefaultPromise<>(eventExecutors);


        eventExecutors.submit(()->{
            System.out.println("1");
            try {
                promise.await();
                // 注意不能仅捕获 InterruptedException 异常
                // 否则 死锁检查抛出的 BlockingOperationException 会继续向上传播
                // 而提交的任务会被包装为 PromiseTask，它的 run 方法中会 catch 所有异常然后设置为 Promise 的失败结果而不会抛出
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("2");
        });
        eventExecutors.submit(()->{
            System.out.println("3");
            try {
                promise.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("4");
        });
        System.in.read();
    }
}
