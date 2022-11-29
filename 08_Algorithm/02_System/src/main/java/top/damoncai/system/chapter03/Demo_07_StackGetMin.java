package top.damoncai.system.chapter03;


public class Demo_07_StackGetMin {

    public static void main(String[] args) {
        StackGetMin stack = new StackGetMin();

        stack.add(3);
        stack.add(2);
        stack.add(4);
        stack.add(3);
        stack.add(1);

        System.out.println("最小值：" + stack.getMin());
        System.out.println("弹出一个数：" + stack.poll());
        System.out.println("最小值：" + stack.getMin());
    }

}

class StackGetMin{

    private LLForStack commonStack = new LLForStack();
    private LLForStack minStack = new LLForStack();

    // 添加数据
    public void add(Integer ele) {
        commonStack.add(ele);

        Integer headVal = minStack.peek();
        // 最小值栈中无数据 直接添加
        if(headVal == null)
            minStack.add(ele);
        else // 最小值栈中有数据 比较添加
            minStack.add(ele < headVal ? ele : headVal);
    }

    // 获取数据
    public Integer poll() {
        Integer ans = commonStack.poll();
        minStack.poll();
        return ans;
    }

    // 获取最小值
    public Integer getMin() {
        return minStack.peek() == null ? null : minStack.peek();
    }

}
