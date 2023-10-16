package center.helloworld.juc2023._06_Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhishun.cai
 * @create 2023/10/12
 * @note condition生产者和消费者实现
 */
public class Demo_01_Condition_Produce_Consumer {

    static int bucket = 0;

    static ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args) {
        Condition condition = lock.newCondition();

        // 生产者线程
        new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    if(bucket == 100) {
                        condition.signal();
                        condition.await();
                    }
                    bucket++;
                    System.out.println(bucket);
                }catch (Exception e) {

                }finally {
                    lock.unlock();
                }
            }
        }).start();

        // 消费者线程
        new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    if(bucket == 0) {
                        condition.signal();
                        condition.await();
                    }
                    bucket--;
                    System.out.println(bucket);
                }catch (Exception e) {

                }finally {
                    lock.unlock();
                }
            }
        }).start();
    }

}
