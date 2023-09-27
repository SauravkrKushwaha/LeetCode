package LeetCode_880;
class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0; // Initialize the size of the decoded string as a long to handle large values
        int n = s.length();

        // Calculate the size of the decoded string
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                size *= digit;
            } else {
                size++;
            }
        }

        // Start from the end of the string and work backwards
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int digit = Character.getNumericValue(c);
                size /= digit;
                k %= size; // Reduce k to the remainder within the current size
            } else {
                if (k == 0 || k == size) {
                    return String.valueOf(c);
                }
                size--;
            }
        }

        return null; // Should never reach here
    }
}

public class Main {
    public static void main(String[] args) {
        String s = "leet2code3";
        int k = 10;
        Solution solution = new Solution();
        String result = solution.decodeAtIndex(s, k);
        System.out.println("The " + k + "th letter in the decoded string is: " + result);
    }
}

