package top.damoncai.system.chapter06;

import lombok.Data;

import java.util.*;

/**
 * @author zhishun.cai
 * @create 2024/6/4
 * @note 修改堆中任何数据都能保证大 | 小堆
 */
@Data
public class HeapGreater<T> {

    /**
     * 堆
     */
    private List<T> heap;

    /**
     * 堆大小
     */
    private int heapSize = 0;

    /**
     * 比较器
     */
    private Comparator<T> comparator;

    /**
     * 映射表 （方便定位到修改数的位置）
     */
    private Map<T, Integer> map;

    public HeapGreater(Comparator<T> comparator) {
        heap = new ArrayList();
        map = new LinkedHashMap();
        this.comparator = comparator;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.heapSize == 0;
    }

    /**
     * 返回堆大小
     * @return
     */
    public int size() {
        return heapSize;
    }

    /**
     * 判断是否包含某个元素
     * @param obj
     * @return
     */
    public boolean contains(T obj) {
        return heap.contains(obj);
    }

    /**
     * 获取堆顶数据，但不删除
     * @return
     */
    public T peek() {
        return heapSize == 0 ? null : heap.get(0);
    }

    /**
     * 插入数据
     * @param obj
     */
    public void push(T obj) {
        heap.add(obj);
        map.put(obj, heapSize);
        heapInset(heapSize ++);

    }

    /**
     * 弹出数据
     * @return
     */
    public T pop() {
        if(heapSize == 0) {
            return null;
        }
        T t = heap.get(0);

        swap(0, -- heapSize);

        heapfiy(0);

        map.remove(t);

        return t;
    }

    /**
     * 删除指定数据
     * @param obj
     */
    public void remove(T obj) {
        Integer index = map.get(obj);
        T lastT = heap.get(heapSize - 1);
        heapSize --;
        map.remove(obj);
        if(lastT != obj) {
            heap.set(index, lastT);
            map.put(lastT, index);
            resign(heap.get(index));
        }
    }

    /**
     * 修改堆中某个对象的值
     * @param obj
     */
    public void resign(T obj) {
        Integer index = map.get(obj);
        // 下面两个方法只会执行一个
        heapInset(index);
        heapfiy(index);
    }

    /**
     * heapInsert
     * @param index
     */
    public void heapInset(int index) {
        // 父节点 - 递归
//        int parentIndex = (index - 1) / 2;
//        if(comparator.compare(heap.get(index), heap.get(parentIndex)) < 0) {
//            swap(index, parentIndex);
//            heapInset(parentIndex);
//        }
        // whie循环
        while (comparator.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }

    }

    /**
     * heapfiy
     * @param index
     */
    public void heapfiy(int index) {
        int childLeftIndex = 2 * index + 1;
        if(childLeftIndex <= (heapSize - 1)) {
            int childRightIndex = childLeftIndex + 1;
            int maxChildIndex = childRightIndex < heapSize && comparator.compare(heap.get(childLeftIndex), heap.get(childRightIndex)) > 0 ? childRightIndex : childLeftIndex;
            if(comparator.compare(heap.get(index), heap.get(maxChildIndex)) > 0) {
                swap(index, maxChildIndex);
                heapfiy(maxChildIndex);
            }
        }

    }

    /**
     * 打印堆信息
     */
    public void printHeap() {
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < heapSize; i++) {
            if(i != 0) {
                sb.append(",");
            }
            sb.append(heap.get(i));
        }
        System.out.println(sb.toString());
    }

    /**
     * 交换数据
     * @param v1
     * @param v2
     */
    public void swap(int v1, int v2) {
        T temp = heap.get(v1);
        heap.set(v1, heap.get(v2));
        heap.set(v2, temp);

        map.put(heap.get(v1), v1);
        map.put(heap.get(v2), v2);
    }

    public static void main(String[] args) {
        HeapGreater<Integer> heap = new HeapGreater(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });


        heap.push(5);
        heap.push(4);
        heap.push(3);
        heap.push(1);
        heap.push(1);
        heap.push(2);

        heap.printHeap();

        System.out.println("======================");

        System.out.println(heap.pop());
        heap.printHeap();
        System.out.println(heap.pop());
        heap.printHeap();
        System.out.println(heap.pop());
        heap.printHeap();
        System.out.println(heap.pop());
        heap.printHeap();
        System.out.println(heap.pop());
        heap.printHeap();
        System.out.println(heap.pop());
        heap.printHeap();
        System.out.println(heap.pop());
        heap.printHeap();

    }
}
