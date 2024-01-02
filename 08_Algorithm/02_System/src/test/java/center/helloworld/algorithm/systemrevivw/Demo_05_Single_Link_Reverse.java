package center.helloworld.algorithm.systemrevivw;

/**
 * @author zhishun.cai
 * @create 2023/12/27
 * @note 单项链表反转
 */
public class Demo_05_Single_Link_Reverse {

    public static void main(String[] args) {
        Node header = generateNode(5, 10);
        printList(header);

        header = reverse(header);
        printList(header);
    }

    public static Node reverse(Node header) {
        if(header == null || header.next == null) return header;
        Node pre = null;
        Node next = null;
        while (header != null) {
            next = header.next;
            header.next = pre;
            pre = header;
            header = next;

        }
        return pre;
    }

    /**
     * 生成链表
     * @param listLen
     * @param maxNum
     * @return
     */
    private static Node generateNode(int listLen, int maxNum) {

        int headVal = (int)(Math.random() * maxNum ) + 1;
        Node head = new Node(headVal);
        Node tail = head;

        listLen--;

        for (int i = 0; i < listLen; i++) {
            int value = (int)(Math.random() * maxNum ) + 1;
            Node node = new Node(value);
            tail.next = node;
            tail = node;
        }
        return head;
    }


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
}
