package LeetCode_2037;
import java.util.Arrays;

class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums); // Sort the array first

        int moves = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int target = nums[i - 1] + 1;
                moves += target - nums[i];
                nums[i] = target;
            }
        }
        return moves;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] nums1 = {1, 2, 2};
        System.out.println("Minimum moves for nums1: " + solution.minIncrementForUnique(nums1)); // Output: 1

        int[] nums2 = {3, 2, 1, 2, 1, 7};
        System.out.println("Minimum moves for nums2: " + solution.minIncrementForUnique(nums2)); // Output: 6

        int[] nums3 = {3, 2, 1, 1, 1, 2, 2, 2, 3, 3};
        System.out.println("Minimum moves for nums3: " + solution.minIncrementForUnique(nums3)); // Output: 12
    }
}

