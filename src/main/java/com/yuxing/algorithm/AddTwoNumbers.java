package com.yuxing.algorithm;

/**
 * 两数相加
 * 
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * @author yuxing
 * @since 2022/2/18
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode result = addTwoNumbers(l1, l2);
        System.err.println(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode p1 = l1, p2 = l2, tail = null;
        boolean carry = false;

        while (p1 != null || p2 != null) {
            int i;
            if (p1 != null && p2 != null) {
                i = p1.val + p2.val;
            }
            else if (p1 == null) {
                i = p2.val;
            }
            else {
                i = p1.val;
            }
            if (carry) {
                i++;
            }
            carry = (i >= 10);
            int val = carry ? i & 9 : i;
            if (tail == null) {
                tail = new ListNode(val);
                result = tail;
            } else {
                tail.next = new ListNode(val);
                tail = tail.next;
            }

            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }

        if (carry) {
            tail.next = new ListNode(1);
        }

        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
