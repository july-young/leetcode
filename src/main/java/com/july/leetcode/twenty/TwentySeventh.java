package com.july.leetcode.twenty;

public class TwentySeventh {
    public static void main(String[] args) {
        System.out.println(
                new TwentySeventh().removeElement(new int[]{3,2,2,3},3)
        );
    }
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i]) {

            } else {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
