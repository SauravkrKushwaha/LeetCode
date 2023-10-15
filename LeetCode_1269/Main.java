package LeetCode_1269;

class Solution {
    public int numWays(int steps, int arrLen) {
        int m = steps;
        int n = Math.min(steps / 2 + 1, arrLen);

        int[][] dp = new int[m + 1][n];
        dp[0][0] = 1;

        int mod = 1000000007;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                }
                if (j < n - 1) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
                }
            }
        }

        return dp[m][0];
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int steps = 3; // Replace with your desired number of steps
        int arrLen = 2; // Replace with the length of the array

        int result = solution.numWays(steps, arrLen);
        System.out.println("Number of ways to reach 0th index: " + result);
    }
}