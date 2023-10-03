package LeetCode_1512;
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 2, 3, 1, 1, 3};
        int result = solution.numIdenticalPairs(nums);

        System.out.println("Number of identical pairs: " + result);
    }
}

