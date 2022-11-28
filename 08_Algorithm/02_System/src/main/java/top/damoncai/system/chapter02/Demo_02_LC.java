package top.damoncai.system.chapter02;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Demo_02_LC {

    /**
     * 一个数组中有一种数出现K次，其他数都出现了M次，
     * M > 1,  K < M
     * 找到，出现了K次的数
     * 要求，额外空间复杂度O(1)，时间复杂度O(N)
     *
     * 这里采用对数器进行校验
     */
    public static void main(String[] args) {
        // 测试次数
        int testTime = 100;
        int kMMax = 9;
        for (int i = 0; i < testTime; i++) {
            // 生成 k,m
            int a = (int)(Math.random() * kMMax) + 1; //[1,9]
            int b = (int)(Math.random() * kMMax) + 1; //[1,9]
            int k = Math.min(a, b);
            int m = Math.max(a,b);
            if(k == m) m++;
            System.out.println("k:" + k + ",m:" +m);
            int[] arr = generateLCArr(k, m, 100, 3);
            System.out.println(Arrays.toString(arr));
            int val1 = onlyTimes(arr, k, m);
            int val2 = test(arr,k,m);
            if(val1 != val2) System.out.println("出错了~~：" + Arrays.toString(arr));
        }
    }

    /**
     * 测试案例
     * @param arr
     * @param k
     * @param m
     * @return
     */
    private static int test(int[] arr, int k, int m) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // hash映射
        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele,0) + 1);
        }

        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            if(value ==  k) {
               return key;
            }
        }
        return -1;
    }

    private static int onlyTimes(int[] arr, int k, int m) {
        // 定义零时数组防止各位数之和
        int[] temp = new int[32];

        for (int ele : arr) {
            for (int i = 0; i < 32; i++) {
                temp[i] += ((ele >> i) & 1);
            }
        }

        int ans = 0;

        for (int i = 0; i < 32; i++) {
            if((temp[i] % m) != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    /**
     * 生成对对数器数组
     * @param k k次
     * @param m m次
     * @param range 范围
     * @param sampleNum 样品数
     * @return
     */
    public static int[] generateLCArr(int k, int m, int range, int sampleNum) {
        // 创建返回数组
        int[] arr = new int[k + (sampleNum - 1) * m];
        int arrIndex = 0;

        HashSet<Integer> sets = new HashSet<>();
        // 生成 k数 [0, range]
        int kNum = (int) (Math.random() * range) + 1;

        // 将出现k的数添加到数组中
        for (; arrIndex < k; arrIndex++) {
            arr[arrIndex] = kNum;
        }

        // 添加集合中避免后续生成重复
        sets.add(kNum);


        sampleNum--;
        // 添加出现过m次的数
        for (int i = 0; i < sampleNum; i++) {
            // 出现m次的随机数 生成随机数
            int mVal = 0;
            do {
                mVal =  generateMVal(range);
            }while (sets.contains(mVal));
            sets.add(mVal);

            // 添加至数组中
            for (int j = 0; j < m; j++) {
                arr[arrIndex++] = mVal;
            }
        }

        return arr;
    }

    /**
     * 生成m值 [-range, range]
     * @param range
     * @return
     */
    private static int generateMVal(int range) {
        return ((int)( Math.random() * range)  + 1) - ((int) (Math.random()  * range) + 1);
    }
}
