package center.hellowrold.jvm.chapter07;

/**
 * @author zhishun.cai
 * @create 2023/11/3
 * @note 设置堆空间大小
 */
public class Demo_01_SetHeapSize {

    /**
     *
     *  1. 设置堆空间大小
     *      -Xms 用于表示堆区的起始内存，等价于-XX:InitialHeapSize
     *      -Xmx则用于表示堆区的最大内存，等价于-XX:MaxHeapSize
     *
     *  2. 初始内存大小：物理电脑内存大小 / 64
     *     最大内存大小：物理电脑内存大小 / 4
     *
     *  3. 查看内存使用信息
     *      1. 方式一：jps   / jstat -gc 进程ID
     *      2. 方式二：-XX:PrintGCDetails
     */
    public static void main(String[] args) throws InterruptedException {
        long totalMemory = Runtime.getRuntime().totalMemory() / 1024 /1024;
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        System.out.println(totalMemory + "M");
        System.out.println(maxMemory + "M");
    }
}
