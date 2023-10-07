package center.helloworld.juc2023._01_CreateThread;

/**
 * 实现Runnerable接口 - 创建线程
 */
public class Demo_02_Runnerable {

    public static void main(String[] args) {
        MyRunnerable runnerable = new MyRunnerable();
        Thread t1 = new Thread(runnerable);
        t1.start();
    }

}

class MyRunnerable implements Runnable {

    @Override
    public void run() {
        System.out.println("子线程运行");
    }
}
