package LeetCode_135;
import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];

        // Initialize each child with one candy.
        Arrays.fill(candies, 1);

        // Traverse from left to right, and ensure that children with higher ratings
        // get more candies than their left neighbors.
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Traverse from right to left, and ensure that children with higher ratings
        // get more candies than their right neighbors. Keep track of the minimum
        // candies required for each child.
        int minCandies = candies[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            minCandies += candies[i];
        }

        return minCandies;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage:
        int[] ratings = {1, 0, 2};
        int minCandies = solution.candy(ratings);
        System.out.println("Minimum candies needed: " + minCandies);
    }
}

