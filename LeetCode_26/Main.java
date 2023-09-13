package LeetCode_26;
import java.util.Arrays;
class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0; // Handle the case of an empty array
        }
        int uniqueIndex = 0;
        for (int i = 1; i < length; i++) {
            // Compare the current element with the previous unique element
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i]; // Move the unique element to its correct position
            }
        }

        return uniqueIndex + 1;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int uniqueCount = solution.removeDuplicates(nums);
        System.out.println("Unique Count: " + uniqueCount);
        System.out.print("Modified Array: " + Arrays.toString(Arrays.copyOf(nums, uniqueCount)));
        System.out.println();
    }
}
