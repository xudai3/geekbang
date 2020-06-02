package com.xd.geekbang.algo.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    int[] testCases = {4,2,1,5,7,0,4,6,3};
//    int[] testCases = {2,3,1,4};

    void printArray(int[] nums) {
        for (int num : nums) {
            System.out.printf("%d ", num);
        }
        System.out.println();
    }

    @Test
    void bubbleSort() {
        Sort sort = new Sort();
        printArray(testCases);
        sort.bubbleSort(testCases);
        printArray(testCases);
    }

    @Test
    void insertionSort() {
        Sort sort = new Sort();
        printArray(testCases);
        sort.insertionSort(testCases);
        printArray(testCases);
    }

    @Test
    void selectionSort() {
        Sort sort = new Sort();
        printArray(testCases);
        sort.selectionSort(testCases);
        printArray(testCases);
    }

    @Test
    void mergeSort() {
        Sort sort = new Sort();
        printArray(testCases);
        sort.mergeSort(testCases);
        printArray(testCases);
    }

    @Test
    void quickSort() {
        Sort sort = new Sort();
        printArray(testCases);
        sort.quickSort(testCases);
        printArray(testCases);
    }

    @Test
    void bucketSort() {
        Sort sort = new Sort();
        printArray(testCases);
        sort.bucketSort(testCases);
        printArray(testCases);
    }

    @Test
    void countingSort() {
        Sort sort = new Sort();
        printArray(testCases);
        sort.countingSort(testCases);
        printArray(testCases);
    }
}