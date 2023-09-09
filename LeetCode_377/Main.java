package LeetCode_377;

class Solution {
    public static int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i - n >= 0) {
                    dp[i] += dp[i - n];
                }
            }
        }
        return dp[target];
    }
}
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        int result = Solution.combinationSum4(nums, target);
        System.out.println("Number of combinations: " + result);
    }
}
