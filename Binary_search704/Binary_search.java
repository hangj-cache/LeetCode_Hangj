package com.hangj.leetcode.Binary_search704;

public class Binary_search {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int middle;
        while (left <= right){
            middle = (left + right) / 2;
            if(target < nums[middle]){
                right = middle - 1;
            }else if(target > nums[middle]){
                left = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }
}
