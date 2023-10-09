package center.helloworld.juc2023._03_ThreadMethods;

/**
 * @author zhishun.cai
 * @create 2023/10/8
 * @note 获取线程
 */
public class Demo_01_GetThread {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread);
        // "Thread[" + getName() + "," + getPriority() + "," +  group.getName() + "]";
        // Thread[main,5,main]
    }
}
