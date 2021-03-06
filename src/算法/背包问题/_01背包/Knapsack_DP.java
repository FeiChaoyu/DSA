package 算法.背包问题._01背包;

import java.util.Arrays;

/**
 * 动态规划
 *
 * 状态定义：F(n, C) 将n个物品放入容量为C的背包
 * 状态转移方程：F(i, c) = max{F(i-1, c), v(i)+F(i-1, c-w(i))}
 * F(i-1, c) 表示不计算当前物品，直接计算后面的物品
 * v(i)+F(i-1, c-w(i)) 表示计算当前物品，然后计算后面的物品
 *
 * @author feichaoyu
 */
public class Knapsack_DP {

    private int[][] memo;

    public int knapsack01(int[] w, int[] v, int C) {

        int n = w.length;
        if (n == 0) {
            return 0;
        }
        // 背包容量从0到C共 C+1个
        memo = new int[n][C + 1];
        Arrays.fill(memo, -1);

        for (int j = 0; j <= C; j++) {
            memo[0][j] = (j >= w[0] ? v[0] : 0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                // 1.不考虑编号为i的物品，直接看i-1的物品
                memo[i][j] = memo[i - 1][j];
                // 2.考虑编号为i的物品
                if (j >= w[i]) {
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - w[i]]);
                }
            }
        }
        return memo[n - 1][C];
    }

    public static void main(String[] args) {

    }
}
