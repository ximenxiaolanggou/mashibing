package top.damoncai.system.chapter05;

import java.util.Arrays;
import java.util.List;

/**
 * 取出顶部数据，并保持堆结构
 */
public class Demo_03_Heapify {

    public static void main(String[] args) {
        System.out.println(1539842152492699650L % 3);
        // 采用数组存储堆数据
        int[] heap = new int[1024];
        // 堆数据长度
        int heapSize = 0;
        // 定义一个集合循环插入数据
        List<Integer> list = Arrays.asList(2,5,6,3,7,9,4);
        for (Integer element : list) {
            // 将新元素添加到尾部
            heap[heapSize] = element;
            // 元素个数加1
            heapSize++;
            heapInsert(heap, heapSize - 1);

        }
        // 打印堆
        printHeap(heap, heapSize);
        System.out.println("===================== poll ===================== ");
        // poll
        int num = poll(heap, heapSize);
        System.out.println(num);
        heapSize--;
        // poll
        num = poll(heap, heapSize);
        System.out.println(num);
        heapSize--;
        // poll
        num = poll(heap, heapSize);
        System.out.println(num);
        heapSize--;
        // poll
        num = poll(heap, heapSize);
        System.out.println(num);
        heapSize--;
        // poll
        num = poll(heap, heapSize);
        System.out.println(num);
        heapSize--;
        // poll
        num = poll(heap, heapSize);
        System.out.println(num);
        heapSize--;
        // poll
        num = poll(heap, heapSize);
        System.out.println(num);
        heapSize--;
    }

    /**
     * poll数据
     * @param heap
     * @param heapSize
     * @return
     */
    private static int poll(int[] heap, int heapSize) {
        // 记录顶数据，并返回
        int num = heap[0];
        // 返回数据前需要保持堆结构
        heapify(heap,heapSize);

        return num;
    }

    /**
     * 逻辑就是将堆最后一个数据放到堆顶，让其下沉
     * 当这个数据比两个子元素都大停止，或者没有子元素停止
     * @param heap
     * @param heapSize
     */
    private static void heapify(int[] heap, int heapSize) {
        // 将尾部数据放入头部
        heap[0] = heap[heapSize - 1];
        int eleIndex = 0;
        // 左孩
        int left = eleIndex * 2 + 1;
        // 右孩
        int right = left + 1;
        // 下沉操作
        // 当前元素存在子节点
        while (left < heapSize) {
            // 获取左右孩子节点较大节点的索引
            int largest = (right < heapSize) && heap[right] > heap[left] ? right : left;
            if(heap[eleIndex] >= heap[largest])
                break;
            swap(heap, eleIndex, largest);
            eleIndex = largest;
            // 左孩
            left = eleIndex * 2 + 1;
            // 右孩
            right = left + 1;

        }
    }

    /**
     * 打印堆信息
     * @param heap
     * @param heapSize
     */
    private static void printHeap(int[] heap, int heapSize) {
        for (int i = 0; i < heapSize; i++) {
            System.out.println(heap[i]);
        }
    }

    /**
     * 插入数据
     * 将数据插入尾部
     * 将新插入数据和父节点比较
     *  1. 直到小于父节点
     *  2. 或者到达顶部（0位置）
     * @param heap
     * @param index 新元素索引
     */
    private static void heapInsert(int[] heap, int index) {
        // 当新元素大于父节点一直循环
        while (heap[index] > heap[(index - 1) / 2]) {
            // 新元素和父节点交换
            swap(heap, index, (index - 1) / 2);
            // 新元素索引位置变成父节点位置
            index = (index - 1) / 2;
        }
    }

    /**
     * 交换数据
     * @param heap
     * @param eleIndex
     * @param parIndex
     */
    private static void swap(int[] heap, int eleIndex, int parIndex) {
        int temp = heap[eleIndex];
        heap[eleIndex] = heap[parIndex];
        heap[parIndex] = temp;
    }
}
