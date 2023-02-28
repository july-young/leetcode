package com.july.leetcode.zero;
/**
 * Definition for singly-linked list.
 **/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
public class Second {

    public static void main(String[] args) {


        ListNode l1 = new ListNode(9);
        l1.next=new ListNode(9);
        l1.next.next=new ListNode(9);
        l1.next.next.next=new ListNode(9);
        l1.next.next.next.next=new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next=new ListNode(9);
        l2.next.next=new ListNode(9);

        ListNode listNode = new Second().addTwoNumbers(l1, l2);

        System.out.println(listNode);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}

