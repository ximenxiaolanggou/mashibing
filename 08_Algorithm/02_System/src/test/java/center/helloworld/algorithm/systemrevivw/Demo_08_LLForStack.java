package center.helloworld.algorithm.systemrevivw;

/**
 * @author zhishun.cai
 * @create 2023/12/28
 * @note 双向链表实现栈
 */
public class Demo_08_LLForStack {

    static DoubleNode head;


    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        push(4);

        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }

    /**
     * 压栈
     * @param ele
     */
    public static void push(Integer ele) {
        DoubleNode node = new DoubleNode(ele);

        if(head == null) {
            head = node;
        }else {
            node.next = head;
            head.last = node;
            head = node;
        }
    }

    /**
     * 出栈
     * @return
     */
    public static Integer pop() {
        if(head == null) return null;

        DoubleNode node = head;

        head = head.next;
        if(head != null)
            head.last = null;

        return node.value;

    }
}
