package LeetCode_172;

class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        for (int i = 5; i <= n; i = i * 5) {
            count = count + n / i;
        }
        return count;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = 25;
        int zeros = solution.trailingZeroes(number);
        System.out.println("Number of trailing zeros in " + number + "! is: " + zeros);
    }
}


