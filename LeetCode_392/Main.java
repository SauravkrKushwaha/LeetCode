package LeetCode_392;

class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0; // Pointer for string 's'
        int tPointer = 0; // Pointer for string 't'

        while (sPointer < s.length() && tPointer < t.length()) {
            // Compare the characters at the current positions in 's' and 't'
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++; // Move the pointer in 's'
            }
            tPointer++; // Always move the pointer in 't'
        }

        // If 'sPointer' reached the end of 's', it means 's' is a subsequence of 't'
        return sPointer == s.length();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "abc";
        String t1 = "ahbgdc";
        boolean result1 = solution.isSubsequence(s1, t1);
        System.out.println("Is '" + s1 + "' a subsequence of '" + t1 + "': " + result1); // Should print true

        String s2 = "axc";
        String t2 = "ahbgdc";
        boolean result2 = solution.isSubsequence(s2, t2);
        System.out.println("Is '" + s2 + "' a subsequence of '" + t2 + "': " + result2); // Should print false
    }
}
