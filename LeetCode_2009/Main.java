package LeetCode_2009;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        // Find unique elements using a set
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : nums) {
            uniqueSet.add(num);
        }

        // Convert unique elements back to an array and sort it
        Integer[] uniqueNums = new Integer[uniqueSet.size()];
        uniqueNums = uniqueSet.toArray(uniqueNums);
        Arrays.sort(uniqueNums);

        int minOperations = n; // Initialize with the maximum possible value

        int left = 0; // Left pointer of the sliding window
        for (int right = 0; right < uniqueNums.length; right++) {
            // Check if the current window is large enough to cover all elements
            while (uniqueNums[right] - uniqueNums[left] >= n) {
                left++;
            }

            // Calculate the number of operations needed to make the window continuous
            int operations = n - (right - left + 1);

            // Update the minimum operations
            minOperations = Math.min(minOperations, operations);
        }

        return minOperations;
    }
}public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 1, 2, 2, 3};
        int[] nums3 = {1, 2, 2, 3, 3, 3};

        int operations1 = solution.minOperations(nums1);
        int operations2 = solution.minOperations(nums2);
        int operations3 = solution.minOperations(nums3);

        System.out.println("Minimum operations for nums1: " + operations1);
        System.out.println("Minimum operations for nums2: " + operations2);
        System.out.println("Minimum operations for nums3: " + operations3);
    }
}



