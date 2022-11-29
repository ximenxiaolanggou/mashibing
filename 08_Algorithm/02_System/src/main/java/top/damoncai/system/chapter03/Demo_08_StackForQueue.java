package top.damoncai.system.chapter03;

public class Demo_08_StackForQueue {


    public static void main(String[] args) {

        StackForQueue queue = new StackForQueue();

        queue.add(1);
        queue.add(2);
        System.out.println(queue.poll());
        queue.add(3);
        queue.add(4);
        System.out.println(queue.poll());
        queue.add(5);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}


/**
 * 栈实现队列
 */
class StackForQueue {

    LLForStack commonStack = new LLForStack();
    LLForStack getStack = new LLForStack();


    /**
     * 添加数据
     * @param ele
     */
    public void add(Integer ele) {
        commonStack.add(ele);
    }

    /**
     * 获取数据
     * @return
     */
    public Integer poll() {
        // 没有数据
        if(getStack.peek() == null && commonStack.peek() == null)
            return null;

        Integer ans;
        // getStack存在数据
        if((ans = getStack.poll()) != null) {
            return ans;
        }

        // getStack没有数据,将栈1中的数据倒入栈2
        pour();
        // 返回栈2 中的数据
        return getStack.poll();
    }

    // 倒入数据
    private void pour() {
        Integer ele;
        while ((ele = commonStack.poll()) != null) {
            getStack.add(ele);
        }
    }
}
