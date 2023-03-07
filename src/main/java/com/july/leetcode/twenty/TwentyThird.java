package com.july.leetcode.twenty;

import com.july.leetcode.common.ListNode;


public class TwentyThird {
    public static void main(String[] args) {


        System.out.println(
                new TwentyThird().mergeKLists(
                        new ListNode[]{
                                new ListNode(1, new ListNode(4, new ListNode(5))),
                                new ListNode(1, new ListNode(3, new ListNode(4))),
                                new ListNode(2, new ListNode(6))
                        }
                )
        );
    }

    public ListNode mergeKLists(ListNode[] lists) {

        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {

        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int middle = (right - left) / 2 + left;

        return merge2List(merge(lists, left, middle), merge(lists, middle + 1, right));
    }

    private ListNode merge2List(ListNode node1, ListNode node2) {

        ListNode head = new ListNode(0);
        ListNode node = head;
        while (node1 != null && node2 != null) {

            if (node1.val < node2.val) {
                node.next = node1;
                node1 = node1.next;
            } else {
                node.next = node2;
                node2 = node2.next;
            }

            node = node.next;
        }

        if (node1 != null) {
            node.next = node1;
        }
        if (node2 != null) {
            node.next = node2;
        }
        return head.next;
    }


}