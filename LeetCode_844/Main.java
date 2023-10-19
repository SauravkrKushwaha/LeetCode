package LeetCode_844;

class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1, back;
        while (true) {
            back = 0;
            while (i >= 0 && (back > 0 || S.charAt(i) == '#')) {
                back += S.charAt(i) == '#' ? 1 : -1;
                i--;
            }
            back = 0;
            while (j >= 0 && (back > 0 || T.charAt(j) == '#')) {
                back += T.charAt(j) == '#' ? 1 : -1;
                j--;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                break;
            }
        }
        return i == -1 && j == -1;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String S1 = "ab#c";
        String T1 = "ad#c";
        boolean result1 = solution.backspaceCompare(S1, T1);
        System.out.println("Test Case 1: " + result1); // Expected output: true

        String S2 = "ab##";
        String T2 = "c#d#";
        boolean result2 = solution.backspaceCompare(S2, T2);
        System.out.println("Test Case 2: " + result2); // Expected output: true

        String S3 = "a##c";
        String T3 = "#a#c";
        boolean result3 = solution.backspaceCompare(S3, T3);
        System.out.println("Test Case 3: " + result3); // Expected output: true

        String S4 = "a#c";
        String T4 = "b";
        boolean result4 = solution.backspaceCompare(S4, T4);
        System.out.println("Test Case 4: " + result4); // Expected output: false
    }
}

