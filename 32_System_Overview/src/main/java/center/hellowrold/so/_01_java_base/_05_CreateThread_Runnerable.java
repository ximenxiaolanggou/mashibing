package center.hellowrold.so._01_java_base;

/**
 * 实现runnerable 接口创建线程
 */
public class _05_CreateThread_Runnerable {
    public static void main(String[] args) {
        // 实现runnerable接口 运行方式
        Thread thread2 = new Thread(new Thread2());
        thread2.start();
    }
}

// 实现runnerale接口
class Thread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread2");
    }
}

