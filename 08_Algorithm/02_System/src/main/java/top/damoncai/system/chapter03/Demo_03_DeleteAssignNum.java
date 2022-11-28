package top.damoncai.system.chapter03;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Demo_03_DeleteAssignNum {

    /**
     * 删除指定数
     * @param args
     */
    public static void main(String[] args) {
        // 链表长度
        int listLen = 10;

        // 链表最大值
        int maxNum = 10;

        // 测试次数
        int testTimes = 100;

        for (int i = 0; i < testTimes; i++) {

            Node orgHead = generateNode(listLen, maxNum);
            int deleteNum = ((int)(Math.random() * maxNum ) + 1);
            System.out.println("原始链表：");
            printList(orgHead);
            System.out.println("需要删除的数为：" + deleteNum);
            // 对数器方法
            Node head01 = test(orgHead, deleteNum);
            // 实际方法
            Node head02 = deleteNum(orgHead, deleteNum);
            boolean compare = compare(head01, head02);
            System.out.println("结果：" + compare);
            printList(head01);
            printList(head02);

        }
    }

    /**
     * 比较
     * @param head01
     * @param head02
     */
    private static boolean compare(Node head01, Node head02) {

        List<Integer> val1s = new ArrayList();
        List<Integer> val2s = new ArrayList();

        while (head01 != null) {
            val1s.add(head01.value);
            head01 = head01.next;
        }

        while (head02 != null) {
            val2s.add(head02.value);
            head02 = head02.next;
        }

       if(val1s.size() != val2s.size()) return false;

        for (int i = 0; i < val1s.size(); i++) {
            if(val1s.get(i) != val2s.get(i)) return false;

        }
        return true;
    }

    /**
     * 删除数
     * @param head
     * @param deleteNum
     * @return
     */
    private static Node deleteNum(Node head, int deleteNum) {
        // 由于存在头结点就需要删除的情况，先找出从头开始第一个不需要删除的节点
        while (head != null) {
            if(!head.value.equals(deleteNum)) break;
            head = head.next;
        }
        Node cur = head;
        Node pre = head;
        while (cur != null) {
            if(cur.value == deleteNum)
                pre.next = cur.next;
            else
                pre = cur;

            cur = cur.next;
        }
        return head;
    }

    /**
     * 对数器方法
     * @param head
     * @return
     */
    private static Node test(Node head, Integer deleteNum) {
        List<Integer> vals = new ArrayList();

        while (head != null) {
            if(head.value != deleteNum)
                vals.add(head.value);
            head = head.next;
        }

        if(vals.size() == 0) return null;

        head = new Node(vals.get(0));
        Node tail = head;
        for (int i = 1; i < vals.size(); i++) {
            tail.next = new Node(vals.get(i));
            tail = tail.next;
        }
        return head;
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

        for (int i = 0; i < maxNum; i++) {
            int value = (int)(Math.random() * maxNum ) + 1;
            Node node = new Node(value);
            tail.next = node;
            tail = node;
        }
        return head;

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

}

