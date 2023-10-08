package center.helloworld.juc2023._04_ThreadMethods;

/**
 * @author zhishun.cai
 * @create 2023/10/8
 * @note InterruptedExeception停止线程
 */
public class Demo_12_StopThread_InterruptedExeception {


    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while(true){
                // 获取任务
                // 拿到任务，执行任务
                // 没有任务了，让线程休眠
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("基于打断形式结束当前线程");
                    return;
                }
            }
        });
        t1.start();
        Thread.sleep(500);
        t1.interrupt();
    }
}
