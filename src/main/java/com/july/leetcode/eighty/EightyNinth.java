package com.july.leetcode.eighty;

import java.util.ArrayList;
import java.util.List;

public class EightyNinth {
    public static void main(String[] args) {
        new EightyNinth().grayCode(3);
    }
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{
            add(0);
        }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }
}