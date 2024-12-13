package com.hangj.leetcode.Remove_Element27;

public class Remove_Element {
    public int removeElement(int[] nums, int val){
        int slow = 0, fast = 0;
        for (fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
