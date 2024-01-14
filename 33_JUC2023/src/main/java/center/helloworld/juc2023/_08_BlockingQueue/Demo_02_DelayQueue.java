package center.helloworld.juc2023._08_BlockingQueue;

import lombok.ToString;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * DelayQueue 使用
 */
public class Demo_02_DelayQueue {
    public static void main(String[] args) throws InterruptedException {
        Task task1 = new Task("A", 5000L);
        Task task2 = new Task("B", 3000L);
        Task task3 = new Task("C", 6000L);
        Task task4 = new Task("D", 1000L);
        Task task5 = new Task("E", 2000L);
        DelayQueue<Task> tasks = new DelayQueue<>();
        tasks.offer(task1);
        tasks.offer(task2);
        tasks.offer(task3);
        tasks.offer(task4);
        tasks.offer(task5);
        System.out.println(tasks.take());
        System.out.println(tasks.take());
        System.out.println(tasks.take());
        System.out.println(tasks.take());
        System.out.println(tasks.take());
    }
}

@ToString
class Task implements Delayed {


    /** 任务的名称 */
    private String name;

    /** 什么时间点执行 */
    private Long time;

    /**
     *
     * @param name
     * @param delay  单位毫秒。
     */
    public Task(String name, Long delay) {
        // 任务名称
        this.name = name;
        this.time = System.currentTimeMillis() + delay;
    }

    /**
     * 设置任务什么时候可以出延迟队列
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        // 单位是毫秒，视频里写错了，写成了纳秒，
        return unit.convert(time - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    /**
     * 两个任务在插入到延迟队列时的比较方式
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        return (int) (this.time - ((Task)o).getTime());
    }

    public long getTime() {
        return this.time;
    }
}

