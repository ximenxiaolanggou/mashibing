package center.helloworld.juc2023._01_CreateThread;

/**
 * 创建线程 - 继承Thread类
 */
public class Demo_01_Thread {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("子线程运行");
    }
}
