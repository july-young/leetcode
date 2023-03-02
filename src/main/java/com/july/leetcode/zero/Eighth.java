package com.july.leetcode.zero;

public class Eighth {
    public static void main(String[] args) {
        System.out.println(
                new Eighth().myAtoi("193 with words")
        );
    }
    public String leftTrim(String s) {

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 48 && c <= 57 || c == '-' || c == '+') {
                return s.substring(i);
            } else if (' ' == c) {
                continue;
            } else {
                return "0";
            }
        }

        return "0";
    }

    public int myAtoi(String str) {

        str = leftTrim(str);
        char[] chars = str.toCharArray();
        int neg = 1;
        int start = 0;
        if (chars[0] == '-') {
            neg = -1;
            start = 1;
        }
        if (chars[0] == '+') {
            neg = 1;
            start = 1;
        }
        long res = 0;
        for (int i = start; i < chars.length; i++) {
            if (chars[i] >= 48 && chars[i] <= 57) {
                res = res * 10 + (chars[i] - 48);
                if (res * neg > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (res * neg < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }

        return ((int) res) * neg;
    }

}