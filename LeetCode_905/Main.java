package LeetCode_905;
import java.util.Arrays;
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] % 2 != 0 && nums[right] % 2 == 0) {
                // Swap nums[left] and nums[right]
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            if (nums[left] % 2 == 0) {
                left++;
            }
            if (nums[right] % 2 != 0) {
                right--;
            }
        }
        return nums;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = {3, 1, 2, 4};
        int[] result1 = solution.sortArrayByParity(nums1);
        System.out.println("Sorted Array 1: " + Arrays.toString(result1));

        // Test case 2
        int[] nums2 = {1, 3, 5, 7};
        int[] result2 = solution.sortArrayByParity(nums2);
        System.out.println("Sorted Array 2: " + Arrays.toString(result2));

        // Test case 3
        int[] nums3 = {2, 4, 6, 8};
        int[] result3 = solution.sortArrayByParity(nums3);
        System.out.println("Sorted Array 3: " + Arrays.toString(result3));
    }
}

