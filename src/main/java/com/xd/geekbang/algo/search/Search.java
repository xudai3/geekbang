package com.xd.geekbang.algo.search;

public class Search {
    public int binarySearch(int[] a, int val) {
        int low = 0;
        int high = a.length - 1;

        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > val) {
                high = mid - 1;
            } else if (a[mid] < val) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int binarySearchRecursive(int[] a, int val) {
        return binarySearchRecursiveInternal(a, 0, a.length-1, val);
    }

    public int binarySearchRecursiveInternal(int []a, int low, int high, int val) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (a[mid] > val) {
            return binarySearchRecursiveInternal(a, low, mid-1, val);
        } else if (a[mid] < val) {
            return binarySearchRecursiveInternal(a, mid+1, high, val);
        } else {
            return mid;
        }
    }

    public int binarySearchFirstElem(int []a, int val) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > val) {
                high = mid - 1;
            } else if (a[mid] < val) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid-1] != val)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public int binarySearchLastElem(int[] a, int val) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > val) {
                high = mid - 1;
            } else if (a[mid] < val) {
                low = mid + 1;
            } else {
                if ((mid == a.length - 1) || (a[mid+1] != val)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
