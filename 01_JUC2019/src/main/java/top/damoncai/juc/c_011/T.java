package top.damoncai.juc.c_011;

/**
 * @author zhishun.cai
 * @date 2020/12/15 21:03
 */

public class T {

    public synchronized void way() throws InterruptedException {
        int i = 0;
        while (true) {
            System.out.println(Thread.currentThread().getName() + " ------ " + i);
            Thread.sleep(1000);
            if(i == 5) {
                throw new RuntimeException("err");
            }
            i++;
        }
    }

    public static void main(String[] args) {
        T t = new T();
        Thread thread001 = new Thread(() -> {
            try {
                t.way();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread001.setName("Thread001");

        Thread thread002 = new Thread(() -> {
            try {
                t.way();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread002.setName("Thread002");

        thread001.start();
        thread002.start();
    }

}
