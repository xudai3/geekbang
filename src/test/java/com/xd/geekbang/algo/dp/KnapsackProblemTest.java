package com.xd.geekbang.algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackProblemTest {

    @Test
    void knapsack2D() {
        int[] weight = {2, 2, 4, 6, 3};
        int n = 5;
        int w = 9;
        KnapsackProblem k = new KnapsackProblem();
        int result = k.knapsack2D(weight, n, w);
        System.out.println(result);
    }
    @Test
    void knapsack1D() {
        int[] weight = {2, 2, 4, 6, 3};
        int n = 5;
        int w = 9;
        KnapsackProblem k = new KnapsackProblem();
        int result = k.knapsack1D(weight, n, w);
        System.out.println(result);
    }
}