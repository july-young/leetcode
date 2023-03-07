package com.july.leetcode.fifty;

public class FifthFifth {
    public static void main(String[] args) {
        new FifthFifth().canJump(new int[]{3,2,1,0,4});
    }
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
