package com.july.leetcode.thirty;

import java.util.*;

public class ThirtyNinth {

    public static void main(String[] args) {
        System.out.println(
                new ThirtyNinth().combinationSum(new int[]{2,3,6,7}, 7)
        );
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 排序是剪枝的前提
        Arrays.sort(candidates);
        Stack<Integer> stack = new Stack<>();
        dfs(candidates, 0, len, target, stack, res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Stack<Integer> stack, List<List<Integer>> res) {
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = begin; i < len; i++) {
            // 重点理解这里剪枝，前提是候选数组已经有序，
            if (target - candidates[i] < 0) {
                break;
            }

            stack.push(candidates[i]);
            dfs(candidates, i, len, target - candidates[i], stack, res);
            stack.pop();
        }
    }
}