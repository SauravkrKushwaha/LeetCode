package LeetCode_2251;
import  java.util.Arrays;
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int n = flowers.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int[] res = new int[persons.length];

        for (int i = 0; i < persons.length; i++) {
            int t = persons[i];
            int started = binarySearchUpperBound(start, t);
            int ended = binarySearchLowerBound(end, t);
            res[i] = started - ended;
        }

        return res;
    }

    private int binarySearchUpperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int binarySearchLowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Sample input data
        int[][] flowers = {
                {1, 4},
                {2, 3},
                {4, 6},
                {8, 10}
        };
        int[] persons = {1, 5, 7};

        // Call the fullBloomFlowers method to calculate the result
        int[] result = solution.fullBloomFlowers(flowers, persons);

        // Display the result
        System.out.println("Result:");
        for (int i = 0; i < persons.length; i++) {
            System.out.println("Person " + persons[i] + " can see " + result[i] + " flowers in full bloom.");
        }
    }
}

