package 剑指offer._10_01_Fibonacci;

/**
 * 动态规划
 * 定义状态：dp[i] 表示第 i 个斐波那契数
 * 状态转移：dp[i] = dp[i-1] + dp[i-2]
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * @author feichaoyu
 */
public class Solution2 {

    public static int fib(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(13));  // 233
    }
}
