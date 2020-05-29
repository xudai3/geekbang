package com.xd.geekbang.algo.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    int[] testCases = {4,2,1,5,7,0,6,3};

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
}