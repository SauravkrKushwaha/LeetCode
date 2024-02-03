package LeetCode_1043;

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int maxVal = arr[i];
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                maxVal = Math.max(maxVal, arr[i - j + 1]);
                dp[i] = Math.max(dp[i], (i - j >= 0 ? dp[i - j] : 0) + maxVal * j);
            }
        }

        return dp[n - 1];
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] arr1 = {1, 15, 7, 9, 2, 5, 10};
        int k1 = 3;
        int result1 = solution.maxSumAfterPartitioning(arr1, k1);
        System.out.println("Example 1: " + result1); // Output: 84

        // Example 2
        int[] arr2 = {1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};
        int k2 = 4;
        int result2 = solution.maxSumAfterPartitioning(arr2, k2);
        System.out.println("Example 2: " + result2); // Output: 83

        // Example 3
        int[] arr3 = {1};
        int k3 = 1;
        int result3 = solution.maxSumAfterPartitioning(arr3, k3);
        System.out.println("Example 3: " + result3); // Output: 1
    }
}

