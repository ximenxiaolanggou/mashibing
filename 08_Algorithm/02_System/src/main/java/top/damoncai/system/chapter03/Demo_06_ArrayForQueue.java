package top.damoncai.system.chapter03;

public class Demo_06_ArrayForQueue {


    public static void main(String[] args) {
        ArrayForQueue queue = new ArrayForQueue(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.add(6);
        queue.add(7);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.add(8);
        queue.add(9);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.add(10);
        queue.add(11);
        queue.add(12);
        System.out.println(queue.poll());
        queue.add(13);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.add(14);
        queue.add(15);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}


/**
 * 数组实现队列
 */
class ArrayForQueue {

    // 存放数据的数组
    final int[] arr;

    // 获取数据的索引
    int pollIndex = 0;

    // 添加数据的索引
    int pushIndex = 0;

    // 使用数据大小
    int size = 0;

    // 数组长度
    int len;

    ArrayForQueue(int capicity) {
        len = capicity;
        arr = new int[capicity];
    }


    public void add(Integer ele) {
        if(size >= len) throw new RuntimeException("队列已满");
        size++;
        arr[pushIndex] = ele;

        pushIndex = nextIndex(pushIndex);
    }

    private int nextIndex(int index) {
        return (++index) % len;
    }

    public Integer poll() {
        if(size == 0) throw new RuntimeException("队列无数据");

        size--;

        Integer ans = arr[pollIndex];
        pollIndex = nextIndex(pollIndex);

        return ans;
    }


}
