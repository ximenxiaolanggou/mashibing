package top.damoncai.juc2022.chapter04;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 数组阻塞队列
 * </p>
 *
 * @author zhishun.cai
 * @since 2022/8/11 10:58
 */
public class Demo_01_ArrayBlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(2);

        // add 添加超出队列大小是抛出异常
        queue.add(1);
        // offer 添加超出队列是返回false
        queue.offer(2);
        System.out.println(queue.offer(3,2, TimeUnit.SECONDS));
        // put 阻塞添加
        queue.put(4);

        // 消费者取数据
        // remove 空队列取数据 抛出异常
        System.out.println(queue.remove());
        // poll 空队列返回false
        System.out.println(queue.poll());
        System.out.println(queue.poll(2,TimeUnit.SECONDS));
        // take 队列中没有数据一直等待
        System.out.println(queue.take());
    }

}
