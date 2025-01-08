package com.hangj.leetcode.sort.Merge_Sort;

/**
 * 1. 分解（Divide）
 * 基本思想：将待排序的数组分成两个大致相等的子数组。
 * 操作步骤：
 * 找到数组的中间位置 mid，将数组分成左右两个子数组。
 * 递归地对左子数组和右子数组进行归并排序。
 * 2. 递归排序（Conquer）
 * 基本思想：对每个子数组进行归并排序，直到子数组的大小为1或0（即已经有序）。
 * 操作步骤：
 * 对左子数组进行归并排序。
 * 对右子数组进行归并排序。
 * 3. 合并（Combine）
 * 基本思想：将两个有序的子数组合并成一个有序的数组。
 * 操作步骤：
 * 创建一个临时数组来存储合并后的结果。
 * 使用两个指针分别指向左子数组和右子数组的起始位置。
 * 比较两个指针所指向的元素，将较小的元素放入临时数组中，并移动相应的指针。
 * 当一个子数组的所有元素都已合并后，将另一个子数组的剩余元素直接复制到临时数组中。
 * 将临时数组中的有序元素复制回原数组。
 */

public class merge_sort {
    public int[] mergesort(int[] arr,int left, int right){
        if(left == right){
            return new int[]{arr[left]};  // 当子数组只有一个元素的时候，就不再递归分裂，直接返回进行后面的组合      这是不断递归的终止条件
        }
        int mid = (left + right) / 2;
        int[] leftArr = mergesort(arr, left, mid);
        int[] rightArr = mergesort(arr, mid + 1, right);
        int[] newNum = new int[leftArr.length + rightArr.length];

        int m = 0, i = 0, j = 0;
        while(i<leftArr.length && j < rightArr.length){
            if(leftArr[i] < rightArr[j]){
                newNum[m] = leftArr[i];
                m++;
                i++;
            }else {
                newNum[m] = rightArr[j];
                m++;
                j++;
            }
        }

        // 下面是左右子数组长度不一致的处理
        while(i<leftArr.length){
            newNum[m] = leftArr[i];
            m++;
            i++;
        }

        while(j<rightArr.length){
            newNum[m] = rightArr[j];
            m++;
            j++;
        }
        return newNum;
    }



}
