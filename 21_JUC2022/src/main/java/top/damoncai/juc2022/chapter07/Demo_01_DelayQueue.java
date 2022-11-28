package top.damoncai.juc2022.chapter07;

import java.util.concurrent.DelayQueue;

//
public class Demo_01_DelayQueue {

    public static void main(String[] args) throws InterruptedException {

        DelayQueue<Delay> queue = new DelayQueue<>();

        Delay dA = new Delay("A", 1000L);
        Delay dB = new Delay("B", 3000L);
        Delay dC = new Delay("C", 5000L);
        Delay dD = new Delay("D", 4000L);

        queue.offer(dA);
        queue.offer(dB);
        queue.offer(dC);
        queue.offer(dD);

        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
    }
}
