package center.helloworld.algorithm.systemrevivw;

/**
 * @author zhishun.cai
 * @create 2023/12/28
 * @note 双向链表实现队列
 */
public class Demo_09_LLForQueue {

    static DoubleNode head;
    static DoubleNode tail;


    public static void main(String[] args) {
        add(1);
        add(2);
        add(3);
        add(4);

        System.out.println(poll());
        System.out.println(poll());
        System.out.println(poll());
        System.out.println(poll());
        System.out.println(poll());
    }

    public static void add(Integer ele) {
        DoubleNode node = new DoubleNode(ele);
        if(head == null) {
            head = node;
            tail = node;
        }else {
            tail.next = node;
            node.last = tail;
            tail = node;
        }
    }

    public static Integer poll() {
        if(head == null) {
            return null;
        }
        Integer ans = head.value;
        if(head == tail) {
            head = null;
            tail = null;
        }else {
            head = head.next;
            head.last = null;
        }

        return ans;
    }
}
