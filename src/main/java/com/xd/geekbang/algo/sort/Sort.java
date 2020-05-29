package com.xd.geekbang.algo.sort;

public class Sort {
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    public void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > val) {
                    nums[j+1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j+1] = val;
        }
    }

    public void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min_idx = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] < nums[min_idx]) min_idx = j;
            }
            int tmp = nums[i];
            nums[i] = nums[min_idx];
            nums[min_idx] = tmp;
        }
    }

    public void mergeSort(int[] nums) {
        mergeSplit(nums, 0, nums.length-1);
    }

    public void mergeSplit(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSplit(nums, l, mid);
        mergeSplit(nums, mid+1, r);
        merge(nums, l, mid, r);
    }

    public void merge(int[] nums, int l, int mid, int r) {
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

}
