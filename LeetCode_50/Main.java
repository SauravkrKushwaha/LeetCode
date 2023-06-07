package LeetCode_50;
class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;

        if (n == Integer.MIN_VALUE) {
            x *= x;
            n /= 2;
        }

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double result = 1.0;
        while (n > 0) {
            if (n % 2 == 1)
                result *= x;

            x *= x;
            n /= 2;
        }

        return result;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        double x = 2.0;
        int n = 10;
        double result = solution.myPow(x, n);
        System.out.println(x + " raised to the power " + n + " is: " + result);

        x = 2.1;
        n = 3;
        result = solution.myPow(x, n);
        System.out.println(x + " raised to the power " + n + " is: " + result);

        x = 2.0;
        n = -2;
        result = solution.myPow(x, n);
        System.out.println(x + " raised to the power " + n + " is: " + result);
    }
}

