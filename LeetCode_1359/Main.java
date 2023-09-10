package LeetCode_1359;

class Solution {
    public int countPickupDelivery(int n) {
        long MOD = 1000000007;
        long factorial = 1;
        long ans = 1;

        for (int i = 1; i <= n; i++) {
            factorial = (factorial * i) % MOD;
            ans = (ans * (2 * i - 1)) % MOD;
        }

        ans = (ans * factorial) % MOD;

        return (int) ans;
    }
}
public class Main {
    public static void main(String[] args) {
        int n = 3; // Replace with the desired value of n
        Solution solution = new Solution(); // Create an instance of the Solution class
        int result = solution.countPickupDelivery(n); // Call the method using the instance
        System.out.println("Count of valid pickup/delivery sequences for n = " + n + ": " + result);
    }
}
