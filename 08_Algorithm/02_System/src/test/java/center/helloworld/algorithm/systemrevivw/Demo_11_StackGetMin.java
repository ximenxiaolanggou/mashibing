package center.helloworld.algorithm.systemrevivw;

/**
 * @author zhishun.cai
 * @create 2023/12/28
 * @note 栈中获取最小数
 */
public class Demo_11_StackGetMin {


    private LLForStack commonStack = new LLForStack();

    private LLForStack minStack = new LLForStack();

    public void add(Integer ele) {
        commonStack.add(ele);
        minStack.add(minStack.peek() == null ? ele : Math.max(ele, minStack.peek()));
    }

    public Integer poll() {
        minStack.poll();
        return commonStack.poll();
    }

    public Integer getMin() {
        return minStack.peek();
    }
}
