package top.damoncai.system.chapter05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 堆数据插入，同时保证大根堆结构
 */
public class Demo_02_HeapInsert {

    public static void main(String[] args) {
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
