package com.july.leetcode.twenty;

public class TwentyEighth {
    public static void main(String[] args) {
        System.out.println(
                new TwentyEighth().strStr("sadbutsad", "sad")
        );
    }
    public int strStr(String haystack, String needle) {
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        int len = haystackChars.length - needleChars.length + 1;
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = 0; j < needleChars.length; j++) {
                if (needleChars[j] == haystackChars[i + j]) {
                    count++;
                } else {
                    break;
                }
            }
            if (count == needleChars.length) {
                return i;
            }
        }
        return -1;
    }
}