package center.helloworld.algorithm.systemrevivw;

import java.util.Arrays;

/**
 * @author zhishun.cai
 * @create 2024/5/21
 * @note
 */
public class Demo_18_Heap {

    static int heap[] = new int[30];
    static int heapSize = 0;

    public static void main(String[] args) {
        heapInsert(3);
        heapInsert(1);
        heapInsert(5);
        heapInsert(8);
        System.out.println(Arrays.toString(heap));

        System.out.println(heapify());
        System.out.println(heapify());
        System.out.println(heapify());
        System.out.println(heapify());
        System.out.println(heapify());
    }



    public static void heapInsert(int v) {
        int index = heapSize;
        int parentIndex;
        heap[heapSize ++] = v;

        while (heap[parentIndex = (index - 1) / 2] < heap[index]) {
            swap(heap, parentIndex, index);
            index = parentIndex;
        }
    }

    public static int heapify() {
        if(heapSize == 0) {
            return -1;
        }
        int v = heap[0];

        swap(heap, 0, heapSize - 1);
        heapSize --;
        int index = 0;
        int left = index * 2 + 1;
        int right = left + 1;
        while (left < heapSize) {
            right = left + 1;

            int largest = right < heapSize && heap[right] > heap[left] ? right : left;
            if(heap[largest] <= heap[index]) {
                break;
            }
            swap(heap, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
        return v;
    }

    public static void swap(int arr[], int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
