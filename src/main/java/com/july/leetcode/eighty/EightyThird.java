package com.july.leetcode.eighty;

import com.july.leetcode.common.ListNode;

public class EightyThird {

    public static void main(String[] args) {
        new EightyThird().deleteDuplicates(new ListNode(1));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
