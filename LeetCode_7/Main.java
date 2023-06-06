package LeetCode_7;

class Solution {
    public int reverse(int x) {
        int reversed = 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        while (x != 0) {
            int lastDigit = x % 10;
            if (reversed > max/10 || (reversed == max/10 && lastDigit > 7)) {
                return 0;
            }
            if (reversed < min/10 || (reversed == min/10 && lastDigit < -8)) {
                return 0;
            }
            reversed = reversed * 10 + lastDigit;
            x /= 10;
        }
        return reversed;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int number1 = 123;
        int number2 = -456;
        int number3 = 0;

        int reversed1 = solution.reverse(number1);
        int reversed2 = solution.reverse(number2);
        int reversed3 = solution.reverse(number3);

        System.out.println("Original: " + number1 + ", Reversed: " + reversed1);
        System.out.println("Original: " + number2 + ", Reversed: " + reversed2);
        System.out.println("Original: " + number3 + ", Reversed: " + reversed3);
    }
}

