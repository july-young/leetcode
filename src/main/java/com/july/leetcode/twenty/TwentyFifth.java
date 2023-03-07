package com.july.leetcode.twenty;

import com.july.leetcode.common.ListNode;

public class TwentyFifth {
    public static void main(String[] args) {
        System.out.println(new TwentyFifth().reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 3));
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if (k == 1) {
            return head;
        }
        ListNode current = head;
        ListNode lastEnd = null;

        boolean first = true;
        ListNode[] nodes = new ListNode[k];
        while (current != null) {
            ListNode right = null;
            ListNode left = null;


            int index = 0;
            for (; index < nodes.length && current != null; index++) {
                nodes[index] = current;
                current = current.next;
            }
            if (index == 0) {
                break;
            }


            if (index == k) {
                left = nodes[nodes.length - 1];
                ListNode tmp = left;
                right = nodes[0];
                right.next = null;
                for (int i = nodes.length - 2; i >= 0; i--) {
                    tmp.next = nodes[i];
                    tmp = tmp.next;
                }
            } else {
                left = nodes[0];
                right = nodes[index - 1];
            }

            if (first) {
                head = left;
                first = false;
            }

            if (lastEnd != null) {
                lastEnd.next = left;
            }
            lastEnd = right;
        }

        return head;
    }
}