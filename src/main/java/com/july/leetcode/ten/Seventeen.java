package com.july.leetcode.ten;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Seventeen {
    public static void main(String[] args) {
        System.out.println(new Seventeen().letterCombinations("23"));
    }
    public List<String> letterCombinations(String digits) {
        List<char[]> charsList = new ArrayList<>();
        char[] two = new char[]{'a', 'b', 'c'};
        char[] three = new char[]{'d', 'e', 'f'};
        char[] four = new char[]{'g', 'h', 'i'};
        char[] five = new char[]{'j', 'k', 'l'};
        char[] six = new char[]{'m', 'n', 'o'};
        char[] seven = new char[]{'p', 'q', 'r', 's'};
        char[] eight = new char[]{'t', 'u', 'v'};
        char[] nine = new char[]{'w', 'x', 'y', 'z'};
        charsList.add(two);
        charsList.add(three);
        charsList.add(four);
        charsList.add(five);
        charsList.add(six);
        charsList.add(seven);
        charsList.add(eight);
        charsList.add(nine);

        List<String> res = new LinkedList<>();

        char[] digitsArray = digits.toCharArray();

        List<char[]> letterList = new ArrayList<>();
        for (int i = 0; i < digitsArray.length; i++) {
            int offset = digitsArray[i] - '2';
            char[] chars = charsList.get(offset);
            letterList.add(chars);
        }

        int level = letterList.size();

        int[] path = new int[level];

        collectPath(letterList, 0, res, path);

        return res;
    }

    public void collectPath(List<char[]> tiles, int level, List<String> bucket, int[] path) {

        if (level >= tiles.size()) {
            return;
        }
        for (int i = 0; i < tiles.get(level).length; i++) {
            path[level] = i;
            collectPath(tiles, level + 1, bucket, path);
            if (level == tiles.size() - 1) {
                char[] cs = new char[path.length];
                for (int j = 0; j < path.length; j++) {
                    cs[j] = tiles.get(j)[path[j]];
                }
                bucket.add(new String(cs));
            }
        }
    }
}