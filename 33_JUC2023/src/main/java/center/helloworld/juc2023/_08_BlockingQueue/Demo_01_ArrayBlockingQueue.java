package center.helloworld.juc2023._08_BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ArrayBlockingQueue 使用
 */
public class Demo_01_ArrayBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

        queue.add(1);
        queue.add(2);
        // add 超出队列容量会抛出异常
        queue.add(3);
        // offer 添加成功返回true，添加失败返回false
        boolean offer = queue.offer(3);
        boolean offer2 = queue.offer(3, 2, TimeUnit.SECONDS);

        // put 如果队列满了，挂起线程，等到队列中有位置，再扔数据进去，死等
        queue.put(3);

        queue.remove();
        queue.remove();
        // remove 从队列中移除数据，如果队列为空，抛出异常
        queue.remove();
        // poll 从队列中移除数据，如果队列为空，返回null，么的数据
        Integer poll = queue.poll();
        Integer poll2 = queue.poll(2, TimeUnit.SECONDS);
        // take 如果队列为空，线程挂起，一直等到生产者扔数据，再获取
        queue.take();
    }
}

