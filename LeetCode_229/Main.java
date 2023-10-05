package LeetCode_229;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        // Find the two potential candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Verify the candidates by counting their occurrences
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            result.add(candidate2);
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {3, 2, 3};
        List<Integer> result1 = solution.majorityElement(nums1);
        System.out.println("Example 1 Output: " + result1);

        // Example 2
        int[] nums2 = {1};
        List<Integer> result2 = solution.majorityElement(nums2);
        System.out.println("Example 2 Output: " + result2);

        // Example 3
        int[] nums3 = {1, 2};
        List<Integer> result3 = solution.majorityElement(nums3);
        System.out.println("Example 3 Output: " + result3);
    }
}

