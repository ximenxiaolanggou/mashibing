package top.damoncai.juc2022.chapter01;

/**
 * 创建线程方式二：定义一个类事项Runnable接口
 */
public class Demo_01_CreateThread_02 {
    public static void main(String[] args) {
        // 创建线程并执行
        new Thread(new TT()).start();
        // main线程循环
        for (int j = 0; j < 100; j++) {
            System.out.println(Thread.currentThread().getName() + "-" + j);
        }
    }
}

class TT implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }
    }
}


