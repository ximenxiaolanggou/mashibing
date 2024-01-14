package center.hellowrold.jvm.chapter11;

/**
 * @author zhishun.cai
 * @create 2023/11/9
 * @note 测试java是否使用引用计数算法
 *
 */
public class Demo_01_TestReferenceCount {

    // 这个成员属性的唯一作用就是占用一点内存
    private byte[] bigSize = new byte[5*1024*1024];
    // 引用
    Object reference = null;


    /**
     * -XX:+PrintGCDetails 添加jvm参数
     */

    public static void main(String[] args) {
        Demo_01_TestReferenceCount obj1 = new Demo_01_TestReferenceCount();
        Demo_01_TestReferenceCount obj2 = new Demo_01_TestReferenceCount();

        obj1.reference = obj2;
        obj2.reference = obj1;

        obj1 = null;
        obj2 = null;
        // 显示的执行垃圾收集行为
        // 这里发生GC，obj1和obj2是否被回收？
        System.gc();
    }
}
