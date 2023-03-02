package com.july.leetcode.zero;

import java.util.Arrays;

public class Ninth {
    public static void main(String[] args) {
        System.out.println(new Ninth().isPalindrome(12321));
    }
    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }
        int[] p = new int[10];
        Arrays.fill(p, -1);
        int idx = 0;
        for (; x != 0; x /= 10) {
            int i = x % 10;
            p[idx++] = i;
        }

        idx--;
        for (int i = 0; i <= idx; i++) {
            if (p[i] != p[idx - i]) {
                return false;
            }
        }
        return true;
    }
}