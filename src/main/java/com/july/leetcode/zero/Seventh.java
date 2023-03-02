package com.july.leetcode.zero;

public class Seventh {
    public static void main(String[] args) {
        System.out.println(
                new Seventh().reverse(123456)
        );
    }

    public int reverse(int i) {
        long v = i;
        int neg = 1;
        if (i < 0) {
            neg = -1;
            v *= -1;
        }
        long res = 0;
        while (v != 0) {

            res = res * 10 + ((int) v % 10);
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                res = 0;
                break;
            }
            v /= 10;
        }

        return (int) res * neg;

    }
}
