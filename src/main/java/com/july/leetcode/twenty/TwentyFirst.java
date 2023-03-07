package com.july.leetcode.twenty;

import com.july.leetcode.common.ListNode;

public class TwentyFirst {
    public static void main(String[] args) {
//        l1 = [1,2,4], l2 = [1,3,4]

        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));


        System.out.println(
                new TwentyFirst().mergeTwoLists(l1, l2)
        );
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode left = l1, r1 = l2;
        ListNode right = r1;
        if (l1 == null && r1 == null) {
            return null;
        }

        ListNode node = null;
        if (left == null) {
            node = right;
            right = right.next;
        } else if (right == null) {
            node = left;
            left = left.next;
        } else {
            if (left.val < right.val) {
                node = left;
                left = left.next;
            } else {
                node = right;
                right = right.next;
            }
        }
        ListNode head = node;


        while (left != null || right != null) {
            if (left == null) {
                node.next = right;
                break;
            }
            if (right == null) {
                node.next = left;
                break;
            }
            if (left.val > right.val) {
                node.next = right;
                right = right.next;
            } else {
                node.next = left;
                left = left.next;
            }

            node = node.next;
        }
        return head;
    }
}