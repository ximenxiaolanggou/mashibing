package center.helloworld.algorithm.systemrevivw;

/**
 * @author zhishun.cai
 * @create 2023/12/28
 * @note 数组实现队列
 */
public class Demo_10_ArrayForQueue {

    static int[] queue = new int[4];

    static int addIndex = 0;
    static int pollIndex = 0;

    static int len = 0;



    public static void main(String[] args) {
        System.out.println(poll());
        add(1);
        add(2);
        add(3);

        System.out.println(poll());
        System.out.println(poll());

        add(4);
        add(5);
        add(6);
        add(7);
        add(8);

        System.out.println(poll());
        System.out.println(poll());
        System.out.println(poll());
        System.out.println(poll());
        System.out.println(poll());
        System.out.println(poll());
    }

    public static void add(Integer ele) {
        if(len == 4) {
            System.out.println("队列已满");
            return;
        }
        queue[addIndex++] = ele;
        if(addIndex == 4) addIndex = 0;

        len++;
    }

    public static Integer poll() {
        if(len == 0) {
            System.out.println("队列为空");
            return null;
        }

        int ele = queue[pollIndex++];
        if(pollIndex == 4) pollIndex = 0;
        len--;
        return ele;
    }
}
