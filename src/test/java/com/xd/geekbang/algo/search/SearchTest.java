package com.xd.geekbang.algo.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest {
    ArrayList<TestCases> testCases = new ArrayList<>();
    public SearchTest() {
        TestCases tc1 = new TestCases();
        tc1.inputArray = new int[]{1,2,3,4,5,6,7,8,9,10};
        tc1.target = 1;
        tc1.expect = 0;
        testCases.add(tc1);
        TestCases tc2 = new TestCases();
        tc2.inputArray = new int[]{1,2,3,4,5,6,7,8,9,10};
        tc2.target = 11;
        tc2.expect = -1;
        testCases.add(tc2);
    }

    @Test
    void TestBSearch() {
       Search s = new Search();
       for (TestCases tc : testCases) {
           assertEquals(tc.expect, s.bsearch(tc.inputArray, tc.target));
       }
    }

    class TestCases {
        int[] inputArray;
        int target;
        int expect;
    }
}
