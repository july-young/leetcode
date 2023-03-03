package com.july.leetcode.ten;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Eighteen {
    public static void main(String[] args) {
        System.out.println(
                new Eighteen().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0)
        );
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {

                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }

                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[left + 1] > target) {
                        break;
                    }
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        while (nums[left] == nums[left + 1] && left < right - 1) {
                            left++;
                        }
                        left++;
                    } else if (sum > target) {
                        while (nums[right] == nums[right - 1] && left < right - 1) {
                            right--;
                        }
                        right--;
                    } else {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[left]);
                        tmp.add(nums[right]);
                        result.add(tmp);
                        while (nums[left] == nums[left + 1] && left < right - 1) {
                            left++;
                        }
                        while (nums[right] == nums[right - 1] && left < right - 1) {
                            right--;
                        }
                        right--;
                    }
                }

                while (j + 1 < nums.length - 1 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            while (i + 1 < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return result;
    }
}
