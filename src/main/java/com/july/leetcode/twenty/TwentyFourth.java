package com.july.leetcode.twenty;

import com.july.leetcode.common.ListNode;

public class TwentyFourth {
    public static void main(String[] args) {
        System.out.println(
                new TwentyFourth().swapPairs(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4)))))
        );
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode start = head.next;
        if (start == null)
            return head;
        ListNode current = head;
        ListNode pre = head;

        while (current != null) {
            ListNode left = current;
            ListNode right = current.next;
            if (right == null) {
                pre.next = left;
                break;
            }
            ListNode next = current.next.next;
            right.next = left;
            left.next = next;
            pre.next = right;
            pre = left;
            left.next = null;
            current = next;
        }
        return start;
    }
}
