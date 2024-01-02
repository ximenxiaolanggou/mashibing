package center.helloworld.algorithm.systemrevivw;

/**
 * @author zhishun.cai
 * @create 2024/1/2
 * @note 栈实现队列
 */
public class Demo_12_StackForQueue {

    private LLForStack mainStack = new LLForStack();

    private LLForStack subStack = new LLForStack();


    /**
     * 添加数据
     */
    public void add(Integer ele) {
        mainStack.add(ele);
    }

    /**
     * 获取数据
     * @return
     */
    public Integer poll() {
        Integer ele = subStack.poll();
        if(ele != null) {
            return ele;
        }
        pour();

        return subStack.poll();
    }

    public void pour() {
        Integer ele = mainStack.poll();
        while (ele != null) {
            subStack.add(ele);
            ele = mainStack.poll();
        }
    }

    public static void main(String[] args) {
        Demo_12_StackForQueue queue = new Demo_12_StackForQueue();

        System.out.println(queue.poll());
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
