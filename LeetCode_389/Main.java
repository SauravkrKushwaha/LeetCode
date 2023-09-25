package LeetCode_389;

class Solution {
    public char findTheDifference(String s, String t) {
        int xorResult = 0;

        for (char c : s.toCharArray()) {
            xorResult ^= c;
        }

        for (char c : t.toCharArray()) {
            xorResult ^= c;
        }

        return (char) xorResult;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String s1 = "abcd";
        String t1 = "abcde";
        System.out.println("Added letter: " + solution.findTheDifference(s1, t1));

        String s2 = "ae";
        String t2 = "aea";
        System.out.println("Added letter: " + solution.findTheDifference(s2, t2));
    }
}

