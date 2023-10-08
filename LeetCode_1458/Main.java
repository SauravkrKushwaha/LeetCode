package LeetCode_1458;
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[][] dp = new int[m][n];

        // Initialize the dp matrix with the product of the first elements of nums1 and nums2
        dp[0][0] = nums1[0] * nums2[0];

        // Fill the first row of dp
        for (int j = 1; j < n; j++) {
            dp[0][j] = Math.max(dp[0][j-1], nums1[0] * nums2[j]);
        }

        // Fill the first column of dp
        for (int i = 1; i < m; i++) {
            dp[i][0] = Math.max(dp[i-1][0], nums1[i] * nums2[0]);
        }

        // Fill the rest of the dp matrix
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // Calculate the current cell's value
                int currentProduct = nums1[i] * nums2[j];

                // Update dp[i][j] by choosing the maximum value from three options:
                // 1. The diagonal cell dp[i-1][j-1] plus the current product.
                // 2. The maximum value from the previous row dp[i-1][j].
                // 3. The maximum value from the previous column dp[i][j-1].
                dp[i][j] = Math.max(currentProduct, Math.max(dp[i-1][j], dp[i][j-1]));

                // If dp[i-1][j-1] is positive, we can consider including it in the subsequence.
                if (dp[i-1][j-1] > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + currentProduct);
                }
            }
        }

        return dp[m-1][n-1];
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {2, 1, -2, 5};
        int[] nums2 = {3, 0, -6};
        int result1 = solution.maxDotProduct(nums1, nums2);
        System.out.println("Example 1: " + result1); // Output should be 18

        // Example 2
        int[] nums3 = {3, -2};
        int[] nums4 = {2, -6, 7};
        int result2 = solution.maxDotProduct(nums3, nums4);
        System.out.println("Example 2: " + result2); // Output should be 21

        // Example 3
        int[] nums5 = {-1, -1};
        int[] nums6 = {1, 1};
        int result3 = solution.maxDotProduct(nums5, nums6);
        System.out.println("Example 3: " + result3); // Output should be -1
    }
}

