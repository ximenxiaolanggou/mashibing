package center.helloworld.algorithm.systemrevivw;

/**
 * @author zhishun.cai
 * @create 2023/12/27
 * @note 单项链表反转
 */
public class Demo_07_Single_Link_Delete {

    public static void main(String[] args) {
        Node header = generateNode(5, 10);
        printList(header);

        header = delete(header,3);
        printList(header);
    }

    public static Node delete(Node header, int delNum) {
        while (header != null && header.value == delNum) {
            header = header.next;
        }
        Node pre = header;
        Node cur = header.next;
        while (header != null && cur != null) {
            while (cur != null && cur.value == delNum) {
                cur = cur.next;
            }
            pre.next = cur;
            pre = cur;
            cur = cur.next;

        }
        return header;
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
