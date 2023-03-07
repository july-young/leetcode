package com.july.leetcode.fifty;

public class FiftyEighth {
    public static void main(String[] args) {
        new FiftyEighth().lengthOfLastWord("");
    }
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
}
