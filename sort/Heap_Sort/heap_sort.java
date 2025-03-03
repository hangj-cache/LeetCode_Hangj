package com.hangj.leetcode.sort.Heap_Sort;

// 推排序：最小堆、最大堆
/**
 * 堆排序需要知道的关键
 * 前置知识
 * 逻辑结构中，假如父节点在物理结构中的索引为parent  那么其左子节点的索引为2*parent+1   假设左子节点为child，那么右子节点则为child+1
 * 对应的，如果左子节点为child 那个其父节点为（child-1）/2
 * 完全二叉树里面最后一个有叶子结点的二叉树的根节点在物理结构中的索引肯定是（n-2）/2
 * 堆排序实质上就是从下往上对每一个堆都进行排序（注意是从下往上），同时是从最下边最右边的堆开始--设置一个算法adjustDown(arr,n,i)  arr就是物理结构的数组，n就是总的节点个数，i是当前堆得root节点索引
 * 这个针对的是完全二叉树
 */

public class heap_sort {
    public void heap_sort_method(int[] nums){
        // nums是待排数组
        int n = nums.length;
        int index = nums.length / 2 - 1;   // 这指向最后拥有儿子节点的根节点

        while(index >= 0){  // index--,这个遍历是一轮中对每一个根节点都进行大顶堆或者小顶堆的调整
            // 循环调整
            correctHeap(nums,index,n);
            index--;
        }
        // 交换头尾，调整堆
        while(n > 1){   // 这是每取一个大顶堆的堆顶都会变换重新进行这个循环调整大顶堆的  ------  注意前面的过程已经将最大堆建好，但是你想获得一个有序数组还需要进行排序，就是每次将堆顶元素拿出，放到数组的最后，将堆的最后一个元素放到堆顶，重新调整。
            swap(nums,0,n-1);
            n--;
            correctHeap(nums,0,n);  // 因为已经经过一次完全调整，其它根节点都已经排号现在就只有堆顶是有问题的，因此只需要在调整一次堆顶就可以了
        }

    }

    public void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public void correctHeap(int[] arr, int index, int n){  // 调整堆的过程就是在对每一个根节点进行大顶调整的时候可能会影响到他的子、子孙节点的顺序，因此才需要进行调整
        // 因为每调整一个点都可能把这个点下面点的编号都打乱，因此这个点下面的点要重新判断   结束条件就是那个点下面没有孩子
        while(2*index+1 < n){
            int left = 2*index+1;  // 左孩子
            int right = 2*index+2; // 右孩子
            int maxIndex = left;
            if(right < n && arr[right] > arr[left]){  // 注意这里是小于，因为n是数组长度，对应到下标只有n-1
                maxIndex = right;
            }
            if(arr[maxIndex] <= arr[index]){
                return;  // 这里只要判断index索引上的元素大于左右孩子中最大的，直接return，是因为原先进行调整的时候就是从底部开始的，因此只要大于左右孩子，那么一定大于左右孩子的孩子。
            }
            swap(arr,maxIndex,index); // 因为调整后影响的肯定不止一层子节点，要是影响了下一层，下下一层也可能被影响。
            index = maxIndex;

        }


    }

}
