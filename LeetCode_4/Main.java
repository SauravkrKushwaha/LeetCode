package LeetCode_4;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure that nums1 is the smaller array
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int imin = 0, imax = m, halfLen = (m + n + 1) / 2;

        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = halfLen - i;

            if (i < m && nums2[j - 1] > nums1[i]) {
                // i is too small, increase it
                imin = i + 1;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                // i is too large, decrease it
                imax = i - 1;
            } else {
                // i is perfect, calculate the median
                int maxOfLeft;
                if (i == 0) maxOfLeft = nums2[j - 1];
                else if (j == 0) maxOfLeft = nums1[i - 1];
                else maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);

                if ((m + n) % 2 == 1) return maxOfLeft;

                int minOfRight;
                if (i == m) minOfRight = nums2[j];
                else if (j == n) minOfRight = nums1[i];
                else minOfRight = Math.min(nums1[i], nums2[j]);

                return (maxOfLeft + minOfRight) / 2.0;
            }
        }

        return 0.0; // This should never happen for valid input arrays.
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double median = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median: " + median);

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        median = solution.findMedianSortedArrays(nums3, nums4);
        System.out.println("Median: " + median);

        int[] nums5 = {0, 0};
        int[] nums6 = {0, 0};
        median = solution.findMedianSortedArrays(nums5, nums6);
        System.out.println("Median: " + median);
    }
}

