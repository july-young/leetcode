package com.july.leetcode.ten;

public class Twelfth {
    public static void main(String[] args) {
        System.out.println(new Twelfth().intToRoman(123));
    }
    public String intToRoman(int num) {
        int[] cells = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] romans = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder sb = new StringBuilder();
        for (int i = cells.length - 1; i >= 0; ) {
            if (num >= cells[i]) {
                num = num - cells[i];
                sb.append(romans[i]);
            } else {
                i--;
            }
        }
        return sb.toString();
    }
}
