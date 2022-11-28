package top.damoncai.system.chapter03;


public class Demo_02_DoubleLinkedListReverse {


    /**
     * 双链表反转
     */
    public static void main(String[] args) {
        DoubleNode node1 = new DoubleNode(1);
        DoubleNode node2 = new DoubleNode(2);
        DoubleNode node3 = new DoubleNode(3);
        DoubleNode node4 = new DoubleNode(4);
        node1.next = node2;
        node1.last = null;

        node2.next = node3;
        node2.last = node1;

        node3.next = node4;
        node3.last = node2;

        node4.next = null;
        node4.last = node3;

        System.out.println("初始状态");
        printNextList(node1);
        DoubleNode reverse = reverse(node1);
        // 反转后状态
        printNextList(reverse);
    }

    /**
     * 打印链表
     * @param head
     */
    private static void printNextList(DoubleNode head) {
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
     * 打印链表
     * @param head
     */
    private static void printLastList(DoubleNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.value);
            sb.append(" -> ");
            head = head.last;
        }
        sb.delete(sb.length() - 4, sb.length());
        System.out.println(sb.toString());
    }

    /**
     * 单链表反转
     * @param head
     * @return
     */
    private static DoubleNode reverse(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

}

/**
 * 节点
 */
class DoubleNode {

    public Integer value;

    public DoubleNode last;

    public DoubleNode next;

    public DoubleNode(Integer value) {
        this.value = value;
    }

}


