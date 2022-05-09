package top.damoncai.basics.class04;

/**
 * 双链表反转
 */
public class Code02_Double_List_Reverse {

    public static void main(String[] args) {
        // 创建双链表
       Node node = createDoubleListNode();
        // 打印输出
        print(node);
        // 反转单链表
        node = reverse(node);
        // 打印输出 
        print(node);
    }

    /**
     * 反转双链表
     *          1 -> 2 -> 3 -> null
     *  null <- 1 <- 2 <- 3
     * @param head
     */
    private static Node reverse(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null ) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }


    /**
     * 创建单链表
     * @return
     */
    private static Node createDoubleListNode() {
        // 1 2 3
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        // 3 2 1
        n1.next.next.last = n1.next;
        n1.next.last = n1;
        return n1;
    }

    /**
     * 打印链表
     * @param node
     */
    private static void print(Node node) {
        Node cur = node;
        Node last = null;
        while (cur != null) {
            System.out.print(cur.value + " ");
            last = cur;
            cur = cur.next;
        }
        System.out.println();

        cur = last;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.last;
        }
        System.out.println();
    }

    public static class Node<V> {
        public Integer value;
        public Node<V> next;
        public Node<V> last;

        public Node(Integer value) {
            this.value = value;
        }
    }

}
