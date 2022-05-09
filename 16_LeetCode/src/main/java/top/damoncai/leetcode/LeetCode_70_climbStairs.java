package top.damoncai.leetcode;

/**
 * @author zhishun.cai
 * @date 2021/5/21 10:27
 */

/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

 */
public class LeetCode_70_climbStairs {
    public static void main(String[] args) {
      int res = climbStairs(3);
      System.out.println(res);
    }

    public static int climbStairs(int n) {
        if(n <= 1) return 1;
        return  climbStairs(n-1) * climbStairs(n-2);
    }
}
