package center.hellowrold.jvm.chapter03;

public class _01_HeapSizeTest {

    public static void main(String[] args) {
        long initalMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;

        System.out.println("-Xms:" + initalMemory);
        System.out.println("-Xmx:" + maxMemory);
    }
}
