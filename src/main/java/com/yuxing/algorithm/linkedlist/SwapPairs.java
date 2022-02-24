package com.yuxing.algorithm.linkedlist;

/**
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * @author yuxing
 * @since 2022/2/24
 */
public class SwapPairs {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode newList = swapPairs(listNode);
        System.err.println(newList);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode p = head;
        ListNode n;
        ListNode prev = null;
        while (p != null && (n = p.next) != null) {
            p.next = n.next;
            n.next = p;
            if (prev != null) {
                prev.next = n;
            }
            if (p == head) {
                head = n;
            }
            prev = p;
            p = p.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
