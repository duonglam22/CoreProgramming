package com.leetcode;
import java.util.*;

class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> mySet = new HashSet<>();
        for (int i = 0; i <nums.length; i++) {
            if (nums[i] > 0) {
                mySet.add(nums[i]);
            }
        }
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!mySet.contains(i)) {
                return i;
            }
        }
        return 1;
    }
}
