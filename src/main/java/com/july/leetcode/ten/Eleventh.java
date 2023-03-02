package com.july.leetcode.ten;

public class Eleventh {
    public static void main(String[] args) {
        System.out.println(new Eleventh().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    public int maxArea(int[] height) {
        int maxArea = 0;

        int left = 0, right = height.length - 1;
        while (true) {
            if (left >= right) {
                break;
            }
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}