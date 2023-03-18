import org.junit.Test;

/**
 * @author zhishun.cai
 * @create 2023/3/1
 * @note
 */
public class ThreadStopTest {

    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.start();

        Thread.sleep(20);
        t1.state = 0;
    }
}

class T1 extends Thread {
    volatile int state = 1;
    @Override
    public void run() {
        while (state == 1) {

        }
        System.out.println("exit");
    }
}
