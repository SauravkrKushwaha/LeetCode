package LeetCode_342;
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println("Is the given no is the power of 4 : "+s1.isPowerOfFour(64));

        Solution s2 = new Solution();
        System.out.println("Is the given no is the power of 4 :"+s2.isPowerOfFour(44));
    }
}
