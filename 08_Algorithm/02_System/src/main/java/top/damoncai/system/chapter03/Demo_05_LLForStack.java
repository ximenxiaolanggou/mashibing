package top.damoncai.system.chapter03;

public class Demo_05_LLForStack {

    /**
     * 双向链表实现栈
     * @param args
     */
    public static void main(String[] args) {
        LLForStack stack = new LLForStack();

        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);


        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());

    }
}

class LLForStack {

    DoubleNode head;

    public void add(Integer ele) {
        DoubleNode node = new DoubleNode(ele);
        if(head == null) {
            head = node;
        }else {

            node.next = head;
            head.last = node;
            head = node;
        }
    }

    public Integer poll() {
        if(head == null) {
            return null;
        }
        Integer ans = head.value;
        head = head.next;

        if(head != null)
            head.last = null;

        return ans;
    }

    // 获取数据
    public Integer peek() {
        return head == null ? null : head.value;
    }
}
