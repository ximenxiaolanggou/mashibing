package top.damoncai.juc2022.chapter09;

import java.util.concurrent.*;

/**
 * newScheduledThreadPool
 */
public class Demo_06_newWorkStealingPool {

    private static int E_NUM = 1_000_000_000;

    private static int datas[] = new int[E_NUM];

    static {
        for (int i = 0; i < datas.length; i++) {
            datas[i] = (int)(Math.random() * 1000);
        }
    }

    public static void main(String[] args) throws Exception {

        // 单线程计算10亿数据

        System.out.println("单线程计算开始");
        long begin = System.nanoTime();
        long sum = 0;
        for (int data : datas) {
            sum += data;
        }
        System.out.println("单线程计结束结果为：" + sum + "，计算时间为：" + (System.nanoTime()  - begin));

        // 使用workStealingPool
        ForkJoinPool forkJoinPool = (ForkJoinPool) Executors.newWorkStealingPool();
        System.out.println("newWorkStealingPool计算开始");
        long forkJoinStart = System.nanoTime();
        ForkJoinTask<Long> task = forkJoinPool.submit(new SumRecursiveTask(0, datas.length - 1));
        Long result = task.join();
        long forkJoinEnd = System.nanoTime();
        System.out.println("分而治之运算结果为：" + result + "，计算时间为：" + (forkJoinEnd  - forkJoinStart));

    }

    public static class SumRecursiveTask extends RecursiveTask<Long> {

        private int start,end;
        private final int MAX_STRIDE = 100_000_000;

        public SumRecursiveTask(int start, int end) {
            this.start = start;
            this.end = end;

        }

        @Override
        protected Long compute() {
            // 在这个方法中，需要设置好任务拆分的逻辑以及聚合的逻辑
            long sum = 0;
            int stride = end - start;
            // 澎【判断是否需要继续拆分任务
            if(stride <= MAX_STRIDE) {
                // 不需要再拆分
                // 可以处理任务
                for (int i = start; i <= end; i++) {
                    sum += datas[i];
                }
            }else {
                // 将任务拆分，分而治之。
                int middle = (start + end) / 2;
                // 声明为2个任务
                SumRecursiveTask left = new SumRecursiveTask(start, middle);
                SumRecursiveTask right = new SumRecursiveTask(middle + 1, end);
                // 分别执行两个任务
                left.fork();
                right.fork();
                // 等待结果，并且获取sum
                sum = left.join() + right.join();
            }
            return sum;
        }
    }
}
