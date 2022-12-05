package top.damoncai.juc2022.chapter11;

import java.util.concurrent.Semaphore;

public class Demo_03_Semaphore {


    public static void main(String[] args) throws InterruptedException {
        // 今天环球影城还有人个人流量
        Semaphore semaphore = new Semaphore(10);

        new Thread(() -> {
            System.out.println("一家三口要去~~");
            try {
                semaphore.acquire(3);
                System.out.println("一家三口进去了~~~");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("一家三口走了~~~");
                semaphore.release(3);
            }
        }).start();

        for (int i = 0; i < 7; i++) {
            int j = i;
            new Thread(() -> {
                System.out.println(j + "大哥来了。");
                try {
                    semaphore.acquire();
                    System.out.println(j + "大哥进去了~~~");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println(j + "大哥走了~~~");
                    semaphore.release();
                }
            }).start();
        }

        Thread.sleep(10);

        System.out.println("main大哥来了。");
        if (semaphore.tryAcquire()) {
            System.out.println("main大哥进来了。");
        }else{
            System.out.println("资源不够，main大哥进来了。");
        }
        Thread.sleep(10000);

        System.out.println("main大哥又来了。");
        if (semaphore.tryAcquire()) {
            System.out.println("main大哥进来了。");
            semaphore.release();
        }else{
            System.out.println("资源不够，main大哥进来了。");
        }
    }
}
