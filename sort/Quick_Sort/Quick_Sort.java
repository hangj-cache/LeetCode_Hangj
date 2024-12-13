package com.hangj.leetcode.sort.Quick_Sort;

import java.awt.*;

public class Quick_Sort {
    public void quick_sort(int[] nums,int low,int high){
        int i, j, pivot;
        if (low > high){
            return;
        }
        i = low;
        j = high;
        pivot = nums[low];
        while(i<j){
            while(nums[j] >= pivot && i<j){
                j--;
            }
            while(nums[i] <= pivot && i<j){
                i++;
            }
            if (i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[low] = nums[i];
        nums[i] = pivot;
        quick_sort(nums,low,i-1);
        quick_sort(nums,i+1,high);
    }
}
