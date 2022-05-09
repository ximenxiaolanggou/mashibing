package top.damoncai.basics.class04;

/**
 * K个节点组内逆序调整
 *  1 2 3 4 5 6 7 8      k=3
 *  3 2 1 6 5 4 7 8      不够k 就不调整
 */
public class Code06_K_Node_Reverse {

    public static void main(String[] args) {
        // 创建单链表
       Node node = createSinglyListNode();
       // 定于 K系数
        int k = 3;
        // 打印输出
        print(node);
        // 反转单链表
        node = reverseKgroup(node,k);
        // 打印输出 
        print(node);
    }

    /**
     * 反转单链表
     *  1 -> 2 -> 3 -> null
     *  null <- 1 <- 2 <- 3
     * @param head
     */
    private static Node reverseKgroup(Node head, int k) {
       Node start = head;
       Node end = getEnd(head,k);
       if(end == null) return head;
        head = end;
       reverse(start,end);
       Node lastEnd = start;
       while (lastEnd.next != null) {
           start = lastEnd.next;
           end = getEnd(start,k);
           if(end == null) break;
           reverse(start,end);
           lastEnd.next = end;
           lastEnd = start;
       }
       return head;
    }

    /**
     * 反转
     * @param start
     * @param end
     */
    private static void reverse(Node start, Node end) {
        end = end.next;
        Node pre = null;
        Node next = null;
        Node cur = start;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    /**
     * 获取借宿节点
     * @param head
     * @param k
     * @return
     */
    private static Node getEnd(Node head, int k) {
        Node end = head;
        while (end != null && --k != 0) {
            end = end.next;
        }
        return end;
    }


    /**
     * 创建单链表
     * @return
     */
    private static Node createSinglyListNode() {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(4);
        n1.next.next.next.next = new Node(5);
        n1.next.next.next.next.next = new Node(6);
        n1.next.next.next.next.next.next = new Node(7);
        n1.next.next.next.next.next.next.next = new Node(8);
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
        public V value;
        public Node<V> next;

        public Node(V value) {
            this.value = value;
        }
    }

}
