package LeetCode_1420;
import java.util.*;
class Solution {
    private static final int MOD = 1000000007;

    public int numOfArrays(int n, int m, int k) {
        // Initialize a memoization table with dimensions (n+1) x (m+1) x (k+1)
        int[][][] memo = new int[n + 1][m + 1][k + 1];

        // Initialize the memoization table with -1 (unprocessed)
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        // Define a recursive function to compute the result
        return dp(n, m, k, memo);
    }

    private int dp(int n, int m, int k, int[][][] memo) {
        // Base cases
        if (n == 0) {
            if (k == 0) {
                return 1;
            }
            return 0;
        }
        if (k < 0 || m == 0) {
            return 0;
        }
        if (memo[n][m][k] != -1) {
            return memo[n][m][k];
        }

        long ans = 0;

        // Case 1: The maximum element is m
        ans += dp(n - 1, m, k, memo);
        ans %= MOD;

        // Case 2: The maximum element is not m
        ans += dp(n - 1, m - 1, k - 1, memo) * m;
        ans %= MOD;

        memo[n][m][k] = (int) ans;
        return (int) ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        int n = 2;
        int m = 3;
        int k = 1;

        int result = solution.numOfArrays(n, m, k);
        System.out.println("Result: " + result);
    }
}

