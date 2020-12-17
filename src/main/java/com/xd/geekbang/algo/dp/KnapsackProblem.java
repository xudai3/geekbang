package com.xd.geekbang.algo.dp;

public class KnapsackProblem {
    /**
     * 0-1背包问题
     * @param weight 物品重量数组
     * @param n 物品数量
     * @param w 背包重量
     * @return 背包能装的最大物品重量
     * 用二维数组保存遍历背包的状态，每次抉择时根据上一次抉择的状态来设置状态
     */
    public int knapsack2D(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w+1];
        // 第一次选取物品时没有上一次的状态，所以需要特殊处理
        states[0][0] = true;
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                if (states[i-1][j]) {
                    if ((j + weight[i]) <= w) {
                        states[i][j+weight[i]] = true;
                    }
                    states[i][j] = true;
                }
            }
        }
        for (int j = w; j >= 0; j--) {
            if (states[n-1][j]) {
                return j;
            }
        }
        return 0;
    }

    /**
     * 0-1背包问题
     * @param weight 物品重量数组
     * @param n 物品数量
     * @param w 背包重量
     * @return 背包能装的最大物品重量
     * 一维数组保存状态
     */
    public int knapsack1D(int[] weight, int n, int w) {
        boolean[] states = new boolean[w+1];
        states[0] = true;
        if (weight[0] <= w) {
            states[weight[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = w-weight[i]; j >= 0; j--) {
                if (states[j]) {
                    states[j+weight[i]] = true;
                }
            }
        }
        for (int j = w; j >= 0; j--) {
            if (states[j]) {
                return j;
            }
        }
        return 0;
    }
}
