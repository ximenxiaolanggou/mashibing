package center.hellowrold.jvm.chapter11;

/**
 * @author zhishun.cai
 * @create 2023/11/13
 * @note 打印GC信息
 */
public class Demo_01_PrintGCInfo {

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
        Demo_01_PrintGCInfo.class.getClassLoader().loadClass("java.lang.LangTest");
        Thread.sleep(10000);


    }
}
