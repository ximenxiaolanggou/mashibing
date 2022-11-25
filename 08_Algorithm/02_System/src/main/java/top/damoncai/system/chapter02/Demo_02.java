package top.damoncai.system.chapter02;


import java.lang.reflect.Array;
import java.util.Arrays;

public class Demo_02 {

    /**
     * 一个数组中有一种数出现K次，其他数都出现了M次，
     * M > 1,  K < M
     * 找到，出现了K次的数
     * 要求，额外空间复杂度O(1)，时间复杂度O(N)
     */
    public static void main(String[] args) {
      int[] arr = {13,66,55,66,13,55,66,55,55,13,66,55,66,13,55,66};

      int k = 4, m = 6;

      // 定义零时数组防止各位数之和
      int[] temp = new int[32];

        for (int ele : arr) {
            for (int i = 0; i < 32; i++) {
//                if(((ele >> i) & 1) != 0)
//                    temp[i] ++;
//                简写为： temp[i] += ((ele >> i) & 1);
                    temp[i] += ((ele >> i) & 1);
            }
        }

        System.out.println(Arrays.toString(temp));

        int res = 0;

        for (int i = 0; i < 32; i++) {
            if((temp[i] % m) != 0) {
                res |= (1 << i);
            }
        }
        System.out.println("出现k次的数为：" + res);
    }
}
