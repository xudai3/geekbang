package com.xd.geekbang.algo.sort;

import java.util.ArrayList;
import java.util.Collections;

public class Sort {
    /**
     * 最好时间复杂度:O(n)   当全部数据已经有序时
     * 最坏时间复杂度:O(n^2)
     * 平均时间复杂度:O(n^2)
     * 空间复杂度:O(1)
     * 稳定   冒泡时遇到相等数字不会进行交换
     */
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    /**
     * 最好时间复杂度:O(n)   当全部数据已经有序时
     * 最坏时间复杂度:O(n^2)
     * 平均时间复杂度:O(n^2)
     * 空间复杂度:O(1)
     * 稳定   后插入的数据遇到相等的元素时直接插入在后面，并不会改变相对位置
     */

    public void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            /*每次要插入的值先存起来*/
            int val = nums[i];
            int j = i - 1;
            /*i之前的数据都是已经有序的，所以从i-1开始往前遍历寻找val所在位置*/
            for (; j >= 0; j--) {
                /*如果找到比val大的数，则从该位置开始所有元素往后挪一个位置*/
                if (nums[j] > val) {
                    nums[j+1] = nums[j];
                } else {
                    break;
                }
            }
            /*j+1就是val所在的最终位置*/
            nums[j+1] = val;
        }
    }

    public void shellSort(int[] nums) {
        for (int step = nums.length / 2; step > 0; step /= 2) {
            for (int i = step; i < nums.length; i++) {
                int val = nums[i];
                int j = i - step;
                for (; j >= 0; j -= step) {
                    if (nums[j] > val) {
                        nums[j+step] = nums[j];
                    } else {
                        break;
                    }
                }
                nums[j+step] = val;
            }
        }
    }

    /**
     * 最好时间复杂度:O(n^2)  即使初始有序，也要全部遍历来寻找每个位置的最小值
     * 最坏时间复杂度:O(n^2)
     * 平均时间复杂度:O(n^2)
     * 空间复杂度:O(1)
     * 不稳定   前面元素与后面最小值交换时，会改变相同元素的相对位置
     */
    public void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min_idx = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[min_idx]) min_idx = j;
            }
            swap(nums, i, min_idx);
        }
    }

    /**
     * 最好时间复杂度:O(nlogn)
     * 最坏时间复杂度:O(nlogn)
     * 平均时间复杂度:O(nlogn)
     * 空间复杂度:O(n)
     * 稳定   merge的时候遇到相同元素，先把前半部分的元素放入tmp数组，这样不会导致元素先后顺序改变
     */
    public void mergeSort(int[] nums) {
        mSort(nums, 0, nums.length-1);
    }

    private void mSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mSort(nums, l, mid);
        mSort(nums, mid+1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] tmpArr = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = mid+1;
        while(p1 <= mid && p2 <= r) {
            if (nums[p1] < nums[p2]) {
                tmpArr[i++] = nums[p1++];
            } else {
                tmpArr[i++] = nums[p2++];
            }
        }
        while(p1 <= mid){
            tmpArr[i++] = nums[p1++];
        }
        while(p2 <= r){
            tmpArr[i++] = nums[p2++];
        }
        for (i = 0; i < tmpArr.length; i++) {
            nums[i+l] = tmpArr[i];
        }
    }

    /**
     * 最好时间复杂度:O(nlogn)
     * 最坏时间复杂度:O(n^2)
     * 平均时间复杂度:O(nlogn)
     * 空间复杂度:根据不同实现方式不同
     * 不稳定   前面找到的大于pivot元素和后面小于pivot元素交换时，就可能改变相同元素的相对位置
     */
    public void quickSort(int[] nums) {
        qSort(nums, 0, nums.length-1);
    }

    private int medianPivot(int[] nums, int l, int r){

        /**
         * 三数取中法，多次比较交换位置，使最左边为最小值，最右边为最大值，中间为中间值，中间值为pivot
         * 最后将pivot放到r-1处，对[l,r-2]进行处理
         */

        int median = l + ((r - l) >> 1);
        if (nums[l] > nums[median]) {
            swap(nums, l, median);
        }
        if (nums[l] > nums[r]) {
            swap(nums, l, r);
        }
        if (nums[median] > nums[r]) {
            swap(nums, median, r);
        }
        swap(nums, median, r-1);
        return r-1;
    }

    private int partition(int[] nums, int l, int r){

        /**
         * 取最右数为pivot，或者随机一个数并交换到最右位置，再对[l,r-1]进行处理
         */
        int storeIndex = l;
        int pivot = r;
        for (int j = l; j < r; j++) {
            if (nums[j] < nums[pivot]) {
                swap(nums, storeIndex, j);
                storeIndex++;
            }
        }
        swap(nums, storeIndex, r);
        return storeIndex;
    }

    private int partitionMedian(int[] nums, int l, int r){

        int pivot = medianPivot(nums, l, r);
        int i = l;
        int j = r-1;
        while(i < j) {
            while(nums[++i] < nums[pivot]) {}
            while(nums[--j] > nums[pivot]) {}
            if(i < j){
                swap(nums, i, j);
            }
        }
        if (i < r-1){
            swap(nums, i, r-1);
        }
        return i;

    }

    private void qSort(int[] nums, int l, int r){

        if (l >= r) {return;}

//        int pivot = partition(nums, l, r);
        int pivot = partitionMedian(nums, l, r);

        qSort(nums, l, pivot-1);
        qSort(nums, pivot+1, r);
    }

    private void swap(int[] nums, int t1, int t2){
        int tmp = nums[t1];
        nums[t1] = nums[t2];
        nums[t2] = tmp;
    }

    public void bucketSort(int []nums){
        int step = 10;
        int[] range = getRange(nums);
        int min = range[0];
        int max = range[1];

        int bucketNum = max / step - min / step + 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();

        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new ArrayList<>());
        }

        for (int num : nums) {
            bucketList.get(num/step).add(num);
        }
        int index = 0;
        for (ArrayList<Integer> bucket : bucketList) {
            Collections.sort(bucket);
            for (Integer num : bucket) {
                nums[index++] = num;
            }
        }
    }

    private int[] getRange(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        return new int[]{min,max};
    }


    public void countingSort(int[] nums) {

        int[] range = getRange(nums);
        int max = range[1];
        int[] countArr = new int[max+1];
        for (int num : nums) {
            countArr[num]++;
        }
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] += countArr[i-1];
        }
        int[] result = new int[nums.length];
        int index;
        for (int i = nums.length-1; i >= 0; i--) {
            index = countArr[nums[i]]-1;
            result[index] = nums[i];
            countArr[nums[i]]--;
        }
        index = 0;
        for (int res : result) {
            nums[index++] = res;
        }
    }

    public void radixSort(int[] nums) {
        int mb = maxBit(nums);
        int step = 10;
        int radix = 1;
        int[] countArr = new int[step];
        int[] tmpArr = new int[nums.length];
        for (int i = 0; i < mb; i++) {
            /*每次循环时将计数数组重新置0*/
            for (int cnt : countArr) {
                cnt = 0;
            }
            /*每位排序使用计数排序*/
            for (int num : nums) {
                int index = num / radix % step;
                countArr[index]++;
            }
            for (int j = 1; j < countArr.length; j++) {
                countArr[j] += countArr[j-1];
            }
            for (int j = nums.length-1; j >=0; j--) {
                int index = nums[j] / radix % step;
                tmpArr[countArr[index]-1] = nums[j];
                countArr[index]--;
            }
            /*将每位排序结果复制回初始数组*/
            for (int j = 0; j < nums.length; j++) {
                nums[j] = tmpArr[j];
            }
            /*下次循环对下一位进行排序*/
            radix *= 10;
        }
    }

    private int maxBit(int[] nums) {
        int step = 10;
        int[] range = getRange(nums);
        int maxNum = range[1];
        int mb = 1;
        while(maxNum >= step) {
            maxNum /= step;
            mb++;
        }
        return mb;
    }

}
