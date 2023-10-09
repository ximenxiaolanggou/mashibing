package center.helloworld.juc2023._04_Thread_Three_Charact;

/**
 * @author zhishun.cai
 * @create 2023/10/9
 * @note Synchronized保证原子性
 */
public class Demo_02_Atomic_Synchronized {

    static int count = 0;

    public static void increment(){
      synchronized (Demo_02_Atomic_Synchronized.class) {
          try {
              Thread.sleep(10);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          count++;
      }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment();
            }
        });

        Thread t2 =new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count);
    }
}
