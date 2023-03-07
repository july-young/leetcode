package com.july.leetcode.twenty;

public class TwentySixth {

    public static void main(String[] args) {
        System.out.println(
                new TwentySixth().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4})
        );
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }

}
