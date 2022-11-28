package top.damoncai.system.chapter03;


import com.sun.xml.internal.ws.addressing.WsaActionUtil;

public class Demo_01_SingleLinkedListReverse {


    /**
     * 单链表反转
     */
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // 处理前输出
        printList(head);

        head = reverse(head);

        // 处理后输出
        printList(head);

    }

    /**
     * 打印链表
     * @param head
     */
    private static void printList(Node head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.value);
            sb.append(" -> ");
            head = head.next;
        }
        sb.delete(sb.length() - 4, sb.length());
        System.out.println(sb.toString());
    }

    /**
     * 单链表反转
     * @param head
     * @return
     */
    private static Node reverse(Node head) {
        Node pre = null;
        Node next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}

/**
 * 节点
 */
class Node {

    public Integer value;

    public Node next;

    public Node(Integer value) {
        this.value = value;
    }

}
