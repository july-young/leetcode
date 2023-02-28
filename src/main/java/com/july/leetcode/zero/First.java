package com.july.leetcode.zero;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class First {
    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target = 13;
        int[] ints = new First().twoSum(nums, target);
        System.out.println(Arrays.toString(ints));

    }


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}

