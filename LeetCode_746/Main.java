package LeetCode_746;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // Create an array to store the minimum cost to reach each step.
        int[] dp = new int[n];
        // Initialize the first two steps in the dp array with their respective costs.
        dp[0] = cost[0];
        dp[1] = cost[1];
        // Iterate from the third step to the top.
        for (int i = 2; i < n; i++) {
            // Calculate the minimum cost to reach the current step by taking the minimum
            // of the cost of reaching the previous step and the step before the previous step,
            // and adding the cost of the current step.
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        // Return the minimum cost to reach the top, which is either the cost of the last step
        // or the step before the last step (whichever is smaller).
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] cost1 = {10, 15, 20};
        int minCost1 = solution.minCostClimbingStairs(cost1);
        System.out.println("Minimum cost for example 1: " + minCost1);

        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int minCost2 = solution.minCostClimbingStairs(cost2);
        System.out.println("Minimum cost for example 2: " + minCost2);
    }
}

