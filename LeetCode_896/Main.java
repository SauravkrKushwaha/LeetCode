package LeetCode_896;
class Solution {
    public boolean isMonotonic(int[] arr) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                increasing = false;
            }
            if (arr[i - 1] < arr[i]) {
                decreasing = false;
            }
        }

        return increasing || decreasing;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int [] arr1 = {1, 2, 2, 4};
        System.out.println(s.isMonotonic(arr1));;

        int[] arr2 = {6, 5, 4, 4};
        System.out.println(s.isMonotonic(arr2));;

        int[] arr3 = {1, 3, 2};
        System.out.println(s.isMonotonic(arr3));;

    }
}
