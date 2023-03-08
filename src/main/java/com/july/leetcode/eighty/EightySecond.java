package com.july.leetcode.eighty;

import com.july.leetcode.common.ListNode;

public class EightySecond {

    public static void main(String[] args) {
        new EightySecond().deleteDuplicates(new ListNode(1));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode a = dummy;
        ListNode b = head.next;
        while (b != null) {
            if (a.next.val != b.val) {
                a = a.next;
                b = b.next;
            } else {
                while (b != null && a.next.val == b.val) {
                    b = b.next;
                }
                //这里的去重跟解法二有点差别，解法二的是
                //a.next = b.next
                a.next = b;
                //b指针在while中判断完后，可能指向了null，这里需要处理边界问题
                b = (b == null) ? null : b.next;
            }
        }
        return dummy.next;
    }
}
