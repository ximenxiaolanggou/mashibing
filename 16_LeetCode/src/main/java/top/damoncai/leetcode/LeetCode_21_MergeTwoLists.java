package top.damoncai.leetcode;

import lombok.ToString;

/**
 * @author zhishun.cai
 * @date 2021/5/21 10:27
 */

/*
    将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

     https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class LeetCode_21_MergeTwoLists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode res = mergeTwoLists(node1,node2);
        System.out.println(res);
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode next = new ListNode();
        node.next = next;
        int index = 1;

        while (l1 != null || l2 != null) {
            if(l1 == null)  index = 2;
            else if (l2 == null) index = 1;
            else if (l1.val < l2.val) index = 1;
            else index = 2;
            if(index == 1) {
                ListNode temp = new ListNode(l1.val);
                next.next = temp;
                next = temp;
                l1 = l1.next;
            }else{
                ListNode temp = new ListNode(l2.val);
                next.next = temp;
                next = temp;
                l2 = l2.next;
            }
        }
        return node.next.next;
    }

}
@ToString
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

