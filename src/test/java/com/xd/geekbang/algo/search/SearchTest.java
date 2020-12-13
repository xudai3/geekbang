package com.xd.geekbang.algo.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {
    class TestCases {
        int[] inputArray;
        int target;
        int expect;
    }
    ArrayList<TestCases> nonDuplicateCases = new ArrayList<>();
    ArrayList<TestCases> firstEqualElemCases = new ArrayList<>();
    ArrayList<TestCases> lastEqualElemCases = new ArrayList<>();
    public SearchTest() {
       TestCases tc1 = new TestCases();
        tc1.inputArray = new int[]{1,2,3,4,5,6,7,8,9,10};
        tc1.target = 1;
        tc1.expect = 0;
        nonDuplicateCases.add(tc1);
        TestCases tc2 = new TestCases();
        tc2.inputArray = new int[]{1,2,3,4,5,6,7,8,9,10};
        tc2.target = 11;
        tc2.expect = -1;
        nonDuplicateCases.add(tc2);
        TestCases tc3 = new TestCases();
        tc3.inputArray = new int[]{1,3,4,5,6,8,8,8,11,13};
        tc3.target = 8;
        tc3.expect = 5;
        firstEqualElemCases.add(tc3);
        TestCases tc4 = new TestCases();
        tc4.inputArray = new int[]{1,1,1,3,4,5,6,8,8,11,13};
        tc4.target = 1;
        tc4.expect = 0;
        firstEqualElemCases.add(tc4);
        TestCases tc5 = new TestCases();
        tc5.inputArray = new int[]{1,3,4,5,6,8,8,8,11,13};
        tc5.target = 8;
        tc5.expect = 7;
        TestCases tc6 = new TestCases();
        tc6.inputArray = new int[]{1,3,4,5,6,8,8,11,13,13,13};
        tc6.target = 13;
        tc6.expect = 10;
    }

    @Test
    void TestBinarySearch() {
       Search s = new Search();
       for (TestCases tc : nonDuplicateCases) {
           assertEquals(tc.expect, s.binarySearch(tc.inputArray, tc.target));
       }
    }

    @Test
    void TestBinarySearchRecursive() {
        Search s = new Search();
        for (TestCases tc : nonDuplicateCases) {
            assertEquals(tc.expect, s.binarySearchRecursive(tc.inputArray, tc.target));
        }
    }

    @Test
    void TestBinarySearchFirstElem() {
        Search s = new Search();
        for (TestCases tc : firstEqualElemCases) {
            assertEquals(tc.expect, s.binarySearchFirstElem(tc.inputArray, tc.target));
        }
    }

    @Test
    void TestBinarySearchLastElem() {
        Search s = new Search();
        for (TestCases tc : lastEqualElemCases) {
            assertEquals(tc.expect, s.binarySearchLastElem(tc.inputArray, tc.target));
        }
    }
}
