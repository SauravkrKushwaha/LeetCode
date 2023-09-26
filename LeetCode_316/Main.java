package LeetCode_316;
import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        // Create a count array to keep track of character occurrences
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Create a boolean array to track if a character is in the result
        boolean[] inResult = new boolean[26];

        // Use a stack to build the result
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            count[c - 'a']--; // Decrease the count of the character in the count array

            if (inResult[c - 'a']) {
                continue; // If the character is already in the result, skip it
            }

            // Pop characters from the stack if they are greater than the current character
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                inResult[stack.pop() - 'a'] = false;
            }

            stack.push(c); // Push the current character into the stack
            inResult[c - 'a'] = true;
        }

        // Build the result string from the stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String input1 = "bcabc";
        String result1 = solution.removeDuplicateLetters(input1);
        System.out.println("Input: " + input1);
        System.out.println("Output: " + result1);

        String input2 = "cbacdcbc";
        String result2 = solution.removeDuplicateLetters(input2);
        System.out.println("\nInput: " + input2);
        System.out.println("Output: " + result2);
    }
}

