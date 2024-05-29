package top.damoncai.system.chapter06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhishun.cai
 * @create 2024/5/29
 * @note 最大重合线数
 */
public class Demo_01_Max_Repeat_Line {

    static int lines[][] = {{2,6},{1,8},{2,5},{1,3},{5,8},{3,9},{7,10}};

    public static void main(String[] args) {
        int cover = maxCover1();
        System.out.println("cover1：" + cover);
        cover = maxCover2();
        System.out.println("cover2：" + cover);
    }

    /**
     * 简单逻辑实现
     * @return
     */
    public static int maxCover1() {
        // 最小值
        int min = Integer.MAX_VALUE;
        // 最大值
        int max = Integer.MIN_VALUE;
        for (int[] line : lines) {
            min = Math.min(min, line[0]);
            max = Math.max(max, line[1]);
        }
        int cover = 0;

        for (double target = min + 0.5; target < max; target++) {
            int num = 0;
            for (int j = 0; j < lines.length; j++) {
                if(lines[j][0] < target && lines[j][1] > target){
                    num++;
                }
            }
            cover = Math.max(cover, num);
        }
        return cover;
    }

    /**
     * 堆实现方式
     * @return
     */
    public static int maxCover2() {
        // 1. 从小到大排序
        Arrays.sort(lines, new MyAscSort());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int cover = 0;
        for (int[] line : lines) {
            if(!queue.isEmpty() && queue.peek() <= line[0]) {
                queue.poll();
            }
            queue.add(line[1]);
            cover = Math.max(cover, queue.size());
        }

        return cover;
    }

}

/**
 * 自定义排序
 */
class MyAscSort implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
    }
}
