package top.damoncai.basics.class03;

import java.util.Arrays;

public class Code02_No_Avg_Random {

    /**
     * 不等概率随机01到等概率
     * 不等概率的随机：[0 ~ 1) 0~0.3 概率为百分之五十 0.3到1为百分之五十
     */
    public static void main(String[] args) {
        int times = 100000;
        int[] arr = new int[2];
        System.out.println("===========不等概率0，1随机===========");
        for (int i = 0; i < times; i++) {
            int ans = f1();
            arr[ans] ++;
        }
        printAvgAssignRes(arr);
        System.out.println("===========等概率0，1随机===========");
        arr = new int[2];
        for (int i = 0; i < times; i++) {
            int ans = f2();
            arr[ans] ++;
        }
        printAvgAssignRes(arr);
    }

    /**
     * 1 - 5的随机
     * @return
     */
    public static int f1() {
        return Math.random() < 0.3 ? 0 : 1;
    }

    /**
     * 返回0或1随机
     * @return
     */
    public static int f2() {
        int ans;
        do {
            ans = f1();
        }while (ans == f1()); // 两次函数调用结果不等时(0,1)或(1,0)才返回
        return  ans;
    }

    /**
     * 打印平均分配测试结果
     * @param arr
     */
    public static void printAvgAssignRes(int[] arr) {
        double sum = (double)Arrays.stream(arr).sum();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + "出现次数：" + arr[i] + ", 占比：" + ((double)arr[i] / sum));
        }
    }
}
