package LeetCode_456;
import java.util.Stack;
class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int[] minArray = new int[n];
        minArray[0] = nums[0];
        for (int i = 1; i < n; i++) {
            minArray[i] = Math.min(minArray[i - 1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int j = n - 1; j >= 0; j--) {
            if (nums[j] <= minArray[j]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() <= minArray[j]) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() < nums[j]) {
                return true;
            }
            stack.push(nums[j]);
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 3, 4};
        boolean result1 = solution.find132pattern(nums1);
        System.out.println("Result 1: " + result1); // Expected output: false

        int[] nums2 = {3, 1, 4, 2};
        boolean result2 = solution.find132pattern(nums2);
        System.out.println("Result 2: " + result2); // Expected output: true

        int[] nums3 = {-1, 3, 2, 0};
        boolean result3 = solution.find132pattern(nums3);
        System.out.println("Result 3: " + result3); // Expected output: true
    }
}

