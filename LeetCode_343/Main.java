package LeetCode_343;
class Solution {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }

        return dp[n];
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 2;
        int result1 = solution.integerBreak(n1);
        System.out.println("For n = " + n1 + ", maximum product is: " + result1);

        int n2 = 10;
        int result2 = solution.integerBreak(n2);
        System.out.println("For n = " + n2 + ", maximum product is: " + result2);
    }
}

