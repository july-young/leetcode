package com.july.leetcode.sixty;

public class SixtySecond {
    public static void main(String[] args) {
        new SixtySecond().uniquePaths(4,5);
    }
    public int uniquePaths(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
