package top.damoncai.basics.class04;

/**
 * 两个有序列表合并
 */
public class Code08_Two_Orderly_Singly_List_To_One_Orderly_Singly_List {

    public static void main(String[] args) {
        // 创建单链表
        Node node1 = createSinglyListNode();
        Node node2 = createSinglyListNode2();
        // 打印输出
        print(node1);
        print(node2);
        // 整合
        Node head = combine(node1,node2);
        print(head);

    }

    /**
     * 整合
     * @param node1
     * @param node2
     * @return
     */
    private static Node combine(Node node1, Node node2) {
        if(node1 == null) return node2;
        if(node2 == null) return node1;

        Node head = node1.value <= node2.value ? node1 : node2;
        Node cur1 = head.next;
        Node cur2 = head == node1 ? node2 : node1;
        Node pre = head;

        while (cur1 != null && cur2 != null) {
            if(cur1.value <= cur2.value) {
                pre.next = cur1;
                cur1 = cur1.next;
            }else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 == null? cur1 : cur2;

        return head;
    }



    /**
     * 创建单链表
     * @return
     */
    private static Node createSinglyListNode() {
        Node n1 = new Node(1);
        n1.next = new Node(3);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(5);
        n1.next.next.next.next = new Node(7);
        return n1;
    }

    /**
     * 创建单链表
     * @return
     */
    private static Node createSinglyListNode2() {
        Node n1 = new Node(2);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(3);
        n1.next.next.next.next = new Node(7);
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
