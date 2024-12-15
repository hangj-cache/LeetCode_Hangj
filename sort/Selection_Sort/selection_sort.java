package com.hangj.leetcode.sort.Selection_Sort;

public class selection_sort {
    public void selection_sort_met(int[] nums){
        int min_ind;
        int min_value;
        for (int i = 0; i < nums.length - 1; i++) {  // i标记要交换的位置
            min_ind = i;
            min_value = nums[i];
            for (int j = i; j < nums.length; j++) {  // j搜索要未排序部分的最小值和最小索引
                if (min_value > nums[j]){
                    min_ind = j;
                    min_value = nums[j];
                }
            }
            int temp = nums[min_ind];
            nums[min_ind] = nums[i];
            nums[i] = temp;
        }
    }
}
