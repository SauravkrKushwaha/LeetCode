package LeetCode_217;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // Found a duplicate
            }
            seen.add(num);
        }

        return false; // No duplicates found
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 3, 1}; // Contains a duplicate (1)
        boolean result1 = solution.containsDuplicate(nums1);
        System.out.println("Array 1 contains duplicates: " + result1);

        int[] nums2 = {1, 2, 3, 4}; // No duplicates
        boolean result2 = solution.containsDuplicate(nums2);
        System.out.println("Array 2 contains duplicates: " + result2);

        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}; // Contains duplicates (1, 3, 4, 2)
        boolean result3 = solution.containsDuplicate(nums3);
        System.out.println("Array 3 contains duplicates: " + result3);
    }
}
