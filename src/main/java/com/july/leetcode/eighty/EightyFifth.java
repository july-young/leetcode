package com.july.leetcode.eighty;

import java.util.Deque;
import java.util.LinkedList;

public class EightyFifth {
    public static void main(String[] args) {
        new EightyFifth().maximalRectangle(new char[][]{});
    }

    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        int[][] left = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int j = 0; j < col; j++) { // 对于每一列，使用基于柱状图的方法
            int[] up = new int[row];
            int[] down = new int[row];

            Deque<Integer> stack = new LinkedList<Integer>();
            for (int i = 0; i < row; i++) {

                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = row - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? row : stack.peek();
                stack.push(i);
            }

            for (int i = 0; i < row; i++) {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }
}