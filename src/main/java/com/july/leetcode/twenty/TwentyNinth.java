package com.july.leetcode.twenty;

public class TwentyNinth {

    public static void main(String[] args) {
        System.out.println(
                divide(1000,3)
        );
    }
    public static int divide(int dividend, int divisor) {


        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long result = div(a, b);
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            result = -result;
        }
        return (int) (result > Integer.MAX_VALUE ? Integer.MAX_VALUE : result < Integer.MIN_VALUE ? Integer.MIN_VALUE : result);
    }

    private static long div(long a, long b) {
        if (a < b) {
            return 0;
        }
        long count = 1;
        long tb = b;
        while ((tb + tb) <= a) {
            count = count + count;
            tb = tb + tb;
        }

        return count + div(a - tb, b);
    }
}