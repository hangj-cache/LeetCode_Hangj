package com.hangj.leetcode.sort.Bubble_Sort;

public class bubble_sort {
    public void bubble_sort_method(int[] nums){
        int i, j;
        for (i = 0; i < nums.length; i++) {
            int temp;
            for (j  = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}
