package top.damoncai.juc2022.chapter06;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Demo_01_PriorityBlockingQueue {

    public static void main(String[] args) {

        demo_01();
    }

    public static void demo_01() {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        queue.offer(3);
        queue.offer(5);
        queue.offer(2);
        queue.offer(1);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
