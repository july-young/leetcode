package com.july.leetcode.sixty;

public class SixtySixth {
    public static void main(String[] args) {
        new SixtySixth().plusOne(new int[]{1,2,3});
    }
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
