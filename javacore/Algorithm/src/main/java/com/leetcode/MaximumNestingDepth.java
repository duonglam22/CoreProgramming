package com.leetcode;
import java.util.*;

class MaximumNestingDepth {
    public int maxDepth(String s) {
        int counter = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                counter++;
                max = Math.max(max, counter);
            } else if (')' == s.charAt(i)) {
                counter--;
            }
        }
        return max;
    }
}
