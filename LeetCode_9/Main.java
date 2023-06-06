package LeetCode_9;

class Solution {
    public boolean isPalindrome(int x) {
        // if the no is a negative or the no endds with zero we will return false
        if(x<0|| (x!=0&& x%10==0))
        {
            return false;
        }
        int reverse = 0;
        int num = x;
        while(num>reverse){
            int lastDigit = num%10;
            reverse=reverse*10+lastDigit;
            num=num/10;
        }
        return num == reverse/10|| num == reverse;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int number1 = 12321;
        int number2 = 12345;
        int number3 = 1221;
        int number4 = 123321;

        boolean isPalindrome1 = solution.isPalindrome(number1);
        boolean isPalindrome2 = solution.isPalindrome(number2);
        boolean isPalindrome3 = solution.isPalindrome(number3);
        boolean isPalindrome4 = solution.isPalindrome(number4);

        System.out.println(number1 + " is palindrome? " + isPalindrome1);
        System.out.println(number2 + " is palindrome? " + isPalindrome2);
        System.out.println(number3 + " is palindrome? " + isPalindrome3);
        System.out.println(number4 + " is palindrome? " + isPalindrome4);
    }
}

