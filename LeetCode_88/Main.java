package LeetCode_88;

import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Pointer for the last element in nums1
        int j = n - 1; // Pointer for the last element in nums2
        int k = m + n - 1; // Pointer for the merged result in nums1

        // Continue merging until either nums1 or nums2 is exhausted
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i]; // Place the larger element from nums1 at nums1[k]
                i--;
            } else {
                nums1[k] = nums2[j]; // Place the larger element from nums2 at nums1[k]
                j--;
            }
            k--;
        }

        // If there are remaining elements in nums2, copy them to nums1
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        Solution solution = new Solution();

        // Call the merge method to modify nums1 in-place
        solution.merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }
}
