package LeetCode_2742;
class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        // Initialize a memoization table with 'null' values to store computed results.
        Long[][] memo = new Long[n][n * 2]; // The maximum total time is n * 2.

        // Start the recursive calculation from the first wall (index 0) with a total time of 0.
        return (int) paintWallsHelper(cost, time, 0, 0, memo);
    }

    private long paintWallsHelper(int[] cost, int[] time, int index, int total, Long[][] memo) {
        // Base case 1: If all walls have been painted, the cost is 0.
        if (total >= cost.length)
            return 0;

        // Base case 2: If we have exceeded the available walls, return a large value.
        if (index >= cost.length)
            return Integer.MAX_VALUE;

        // If the result for this state is already computed, return it from the memo table.
        if (memo[index][total] != null)
            return memo[index][total];

        // Calculate the minimum cost by considering two options:
        // 1. Paint the current wall using the paid painter and move to the next wall with updated total time and cost.
        long with = cost[index] + paintWallsHelper(cost, time, index + 1, total + time[index] + 1, memo);

        // 2. Skip the current wall and move to the next wall with the same total time and cost.
        long without = paintWallsHelper(cost, time, index + 1, total, memo);

        // Store the minimum cost in the memo table for this state.
        return memo[index][total] = Math.min(with, without);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] cost = {1, 2, 3};
        int[] time = {3, 4, 5};

        Solution solution = new Solution();
        int minCost = solution.paintWalls(cost, time);

        System.out.println("Minimum cost to paint the walls: " + minCost);
    }
}

