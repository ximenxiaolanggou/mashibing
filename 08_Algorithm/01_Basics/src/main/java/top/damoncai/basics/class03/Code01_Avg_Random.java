package top.damoncai.basics.class03;

public class Code01_Avg_Random {

    /**
     * 从1-5随机 到 1-7随机
     * 实现思路 1-5随机 - 0-1 随机 1-7随机
     * @param args
     */
    public static void main(String[] args) {
        int times = 100000;
        int[] arr = new int[8];
        for (int i = 0; i < times; i++) {
            int ans = f4();
            arr[ans] ++;
        }
        printAvgAssignRes(arr);
    }

    /**
     * 1 - 5的随机
     * @return
     */
    public static int f1() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 返回0或1随机
     * @return
     */
    public static int f2() {
        int ans;
        do {
            ans = f1();
        }while (ans == 3);
        return  ans < 3 ? 0 : 1;
    }

    public static int f3() {
        int ans1 = f2();
        int ans2 = f2();
        int ans3 = f2();
        return (ans1 << 2) + (ans2 << 1) + (ans3) << 0;
    }

    public static int f4() {
        int num;
        do{
            num = f3();
        }while (num == 0);
        return num;
    }

    /**
     * 打印平均分配测试结果
     * @param arr
     */
    public static void printAvgAssignRes(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + "出现次数：" + arr[i]);
        }
    }
}
