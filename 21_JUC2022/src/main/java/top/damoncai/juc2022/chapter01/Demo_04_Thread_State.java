package top.damoncai.juc2022.chapter01;

/**
 * 线程状态：java中线程分为6中状态，在Thread类中有定义 NEW,RUNNABLE,WAITING,TIME_WAITING，BLOCKED,TERMINATED
 */
public class Demo_04_Thread_State {

    static Object o = new Object();

    public static void main(String[] args) throws Exception {
        newState();
        runnableState();
        blockedState();
        waitingState();
        timewaitingState();
        terminatedState();
    }

    /**
     * NEW：线程被创建但未被调用
     */
    public static void newState() {
        Thread thread = new Thread(() -> {});
        System.out.println(thread.getState());
    }

    /**
     * RUNNABLE：线程启动后处于就绪/运行状态
     */
    public static void runnableState() {
        Thread thread = new Thread(() -> {});
        thread.start();
        System.out.println(thread.getState());
    }

    /**
     * WAITING：调用wait方法就会处于WAITING状态，需要被手动唤醒
     */
    public static void blockedState() throws InterruptedException {
        Thread thread = new Thread(() -> {
            synchronized (o) {

            }
        });

        synchronized (o) {
            thread.start();
            Thread.sleep(1000);
            System.out.println(thread.getState());
        }
    }

    /**
     * WAITING：调用wait方法就会处于WAITING状态，需要被手动唤醒
     */
    public static void waitingState() throws InterruptedException {
        Thread thread = new Thread(() -> {
            synchronized (o) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.getState());
    }

    /**
     * TIME_WAITING：调用sleep方法或者join方法，会被自动唤醒，无需手动唤醒
     */
    public static void timewaitingState() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.getState());
    }

    /**
     * TERMINATED：run方法执行完毕，线程生命周期到头了
     */
    public static void terminatedState() throws InterruptedException {
        Thread thread = new Thread(() -> {

        });
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.getState());
    }
}
