package top.damoncai.basics.class04;

/**
 * 两个单链表相加
 */
public class Code07_Two_Singly_List_Add {

    public static void main(String[] args) {
        // 创建单链表
        Node node1 = createSinglyListNode();
        Node node2 = createSinglyListNode2();
        // 打印输出
        print(node1);
        print(node2);

        Node res = add(node1,node2);
        print(res);
    }

    /**
     * 添加
     * @param node1
     * @param node2
     * @return
     */
    private static Node add(Node node1, Node node2) {
        int len1 = getNodeLen(node1);
        int len2 = getNodeLen(node2);
        Node nodeL = null;
        Node nodeS = null;
        if(len1 > len2) {
            nodeL = node1;
            nodeS = node2;
        }else {
            nodeL = node2;
            nodeS = node1;
        }
        doAdd(nodeL,nodeS);
        return nodeL;
    }

    /**
     * 添加
     * @param nodeL
     * @param nodeS
     */
    private static void doAdd(Node nodeL, Node nodeS) {
        Node pre = nodeL; // 防止只有一个元素
        int tmp = 0;
        while (nodeL != null) {
            int sum = nodeL.value + (nodeS == null ? 0 : nodeS.value) + tmp;
            tmp = sum / 10;
            nodeL.value = sum % 10;
            pre = nodeL;
            nodeL = nodeL.next;
            if(nodeS != null) nodeS = nodeS.next;
        }
        if(tmp != 0) {
            pre.next = new Node(tmp);
        }
    }

    /**
     *  获取node长度
     * @param node
     * @return
     */
    private static int getNodeLen(Node node) {
        int len = 0;
        if(node != null) {
            while (node != null) {
                node = node.next;
                len ++;
            }
        }
        return len;
    }


    /**
     * 创建单链表
     * @return
     */
    private static Node createSinglyListNode() {
        Node n1 = new Node(4);
        n1.next = new Node(3);
        n1.next.next = new Node(6);
        return n1;
    }

    /**
     * 创建单链表
     * @return
     */
    private static Node createSinglyListNode2() {
        Node n1 = new Node(2);
        n1.next = new Node(5);
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
