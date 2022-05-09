package top.damoncai.basics.class04;

import static sun.plugin.dom.DOMObjectFactory.createNode;

/**
 * 单链表反转
 */
public class Code01_Singly_List_Reverse {

    public static void main(String[] args) {
        // 创建单链表
       Node node = createSinglyListNode();
        // 打印输出
        print(node);
        // 反转单链表
        node = reverse(node);
        // 打印输出 
        print(node);
    }

    /**
     * 反转单链表
     *  1 -> 2 -> 3 -> null
     *  null <- 1 <- 2 <- 3
     * @param head
     */
    private static Node reverse(Node head) {
        Node per = null;
        Node next = null;
        while (head != null ) {
            next = head.next;
            head.next = per;
            per = head;
            head = next;
        }
        return per;
    }


    /**
     * 创建单链表
     * @return
     */
    private static Node createSinglyListNode() {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        return n1;
    }

    /**
     * 打印链表
     * @param node
     */
    private static void print(Node node) {
        Node cur = node;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static class Node<V> {
        public Integer value;
        public Node<V> next;

        public Node(Integer value) {
            this.value = value;
        }
    }

}
