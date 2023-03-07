package com.july.leetcode.twenty;

import java.util.LinkedList;
import java.util.List;

public class TwentySecond {
    public static void main(String[] args) {

        System.out.println(
                new TwentySecond().generateParenthesis(4)
        );


    }
    public List<String> generateParenthesis(int n) {
        int leftBrace = 0, rightBrace = 0;
        List<String> list = new LinkedList<>();
        getPosition("", n, leftBrace, rightBrace, list);

        return list;
    }

    private void getPosition(String s, int level, int leftBrace, int rightBrace, List<String> set) {
        if (leftBrace == level && rightBrace == level) {
            set.add(s);
        }
        if (leftBrace < rightBrace) {
            return;
        }
        if (leftBrace < level) {
            getPosition(s + "(", level, leftBrace + 1, rightBrace, set);
        }
        if (rightBrace < level) {
            getPosition(s + ")", level, leftBrace, rightBrace + 1, set);
        }

    }

}
