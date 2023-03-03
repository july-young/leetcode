package com.july.leetcode.ten;

public class Sixteen {
    public static void main(String[] args) {
        System.out.println(
                new Sixteen().threeSumClosest(new int[]{-1,2,1,-4}, 1)
        );
    }
    public int threeSumClosest(int[] nums, int target) {


        int loss = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;


        quickSort(nums, 0, nums.length - 1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - target > loss && nums[i] < target) {
                break;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];
                int abLoss = sum - target;

                if (Math.abs(abLoss) < loss) {
                    loss = Math.abs(abLoss);
                    res = sum;
                }
                if (abLoss < 0) {
                    left++;
                } else if (abLoss > 0) {
                    right--;
                } else {
                    return target;
                }
            }
        }

        return res;
    }

    public void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }
}