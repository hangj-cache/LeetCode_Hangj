package com.hangj.leetcode.sort.Insert_Sort;

/**
 * 1.从第一个元素开始，该元素可以认为已经被排序
 * 2.取下一个元素tem，从已排序的元素序列从后往前扫描
 * 3.如果该元素大于tem，则将该元素移到下一位
 * 4.重复步骤3，直到找到已排序元素中小于等于tem的元素
 * 5.tem插入到该元素的后面，如果已排序所有元素都大于tem，则将tem插入到下标为0的位置
 * 6.重复步骤2~5
 */
public class Insert_Sort {
    public void insert_sort(int[] arrays){
        for (int i = 0; i < arrays.length-1; i++) {

            int end = i;// 有序序列最后一个元素的下标
            int val = arrays[end+1]; // 要插入位置的元素
            while(end>=0){
                if (val<arrays[end]){
                    arrays[end+1] = arrays[end];
                    end--;
                }else {
                    break;
                }
            }
            arrays[end+1] = val;
        }
    }
}
