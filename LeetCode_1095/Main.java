package LeetCode_1095;
import java.util.*;
class MountainArray {
    private int[] arr;

    public MountainArray(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        return arr[index];
    }

    public int length() {
        return arr.length;
    }
}

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int left = 0, right = n - 1;

        // Find the peak of the mountain
        while (left < right) {
            int mid = (left + right) / 2;
            int midVal = mountainArr.get(mid);
            int nextVal = mountainArr.get(mid + 1);
            if (midVal < nextVal) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int peak = left;

        // Binary search in the ascending part
        left = 0;
        right = peak;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Binary search in the descending part
        left = peak;
        right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a MountainArray instance (replace this with your actual implementation)
        MountainArray mountainArray = new MountainArray(new int[]{1, 3, 5, 7, 3, 1});

        // Create a Solution instance
        Solution solution = new Solution();

        // Define the target value you want to search for
        int target = 5;

        // Call the findInMountainArray method to search for the target
        int result = solution.findInMountainArray(target, mountainArray);

        // Display the result
        if (result != -1) {
            System.out.println("The target " + target + " was found at index " + result);
        } else {
            System.out.println("The target " + target + " was not found in the mountain array.");
        }
    }
}

