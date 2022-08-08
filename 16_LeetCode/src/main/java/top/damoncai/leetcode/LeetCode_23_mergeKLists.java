package top.damoncai.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhishun.cai
 * @date 2021/5/21 10:27
 */

/*

    Tip: 合并K个升序链表


    给你一个链表数组，每个链表都已经按升序排列。

    请你将所有链表合并到一个升序链表中，返回合并后的链表。

     https://leetcode.cn/problems/merge-k-sorted-lists/
 */

public class LeetCode_23_mergeKLists {


    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(7);
        node1.next = node2;
        node1.next.next = node3;

        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(8);
        ListNode node6 = new ListNode(8);
        node4.next = node5;
        node4.next.next = node6;
        ListNode[] arr = new ListNode[0];
        ListNode node = mergeKLists(arr);
        System.out.println(node);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        if(lists == null || lists.length == 0) return null;
        for (ListNode node : lists) {
            if(node != null)
            queue.add(node);
        }
        ListNode head = queue.poll();
        ListNode pre = head;
        if(head.next != null) {
            queue.add(head.next);
        }
        while (queue.size() > 0) {
            ListNode node = queue.poll();
            pre.next = node;
            pre = node;
            if(node.next != null)  queue.add(node.next);
        }
        return head;
    }


}




