package com.xd.geekbang.algo.search;

public class Search {
    public int bsearch(int[] a, int value) {
        int len = a.length;
        int low = 0;
        int high = len-1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
