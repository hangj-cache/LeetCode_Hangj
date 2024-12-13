package com.hangj.leetcode.sort.Hill_Sort;


/**
 * 1.先选定一个小于N的整数gap作为第一增量，然后将所有距离为gap的元素分在同一组，
 * 并对每一组的元素进行直接插入排序。然后再取一个比第一增量小的整数作为第二增量，重复上述操作…
 * 2.当增量的大小减到1时，就相当于整个序列被分到一组，进行一次直接插入排序，排序完成。
 */
public class hill_sort {
    public void hill_sort_start(int[] arr) {
        int len = arr.length;
        int gap = len;
        while (gap > 1) {
            gap = gap / 2;
            for (int i = 0; i < len - gap; i++) {
                int end = i;
                int temp = arr[end+gap];
                while(end >= 0){
                    if (temp < arr[end]){
                        arr[end+gap] = arr[end];
                        end -= gap;
                    }else{
                        break;
                    }
                }
                arr[end+gap] = temp;
            }
        }
    }
}
