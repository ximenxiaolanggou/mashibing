package top.damoncai.system.chapter03;

public class Demo_04_LLForQueue {

    /**
     * 双向链表实现队列
     * @param args
     */
    public static void main(String[] args) {
        LLForQueue queue = new LLForQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        queue.add(5);
        queue.add(6);


        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}

class LLForQueue {

    DoubleNode head;

    DoubleNode tail;

    public void add(Integer ele) {
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

    public Integer poll() {
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
