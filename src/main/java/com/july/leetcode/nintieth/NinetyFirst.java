package com.july.leetcode.nintieth;

public class NinetyFirst {
    public static void main(String[] args) {
        new NinetyFirst().numDecodings("1");
    }

    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') return 0;
        int cur = 1, pre = 1;
        for (int i = 1; i < chars.length; i++) {
            int tmp = cur;
            if (chars[i] == '0') {
                //如果前一位不是1或者2,显然无法解码
                if (chars[i - 1] != '1' && chars[i - 1] != '2') {
                    return 0;
                }
                cur = pre;
                //如果前一位是1或者2
            } else if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] >= '1' && chars[i] <= '6')) {
                cur = cur + pre;
            } else {
                //虽然此处没有意义，但是为了方便理解，等价O(n)空间复杂度的代码
                cur = cur;
            }
            pre = tmp;
        }
        return cur;
    }
}
