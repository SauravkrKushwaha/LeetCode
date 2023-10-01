package LeetCode_557;
class Solution {
    public String reverseWords(String s) {
        // Split the input string into words
        String[] words = s.split(" ");

        // Create a StringBuilder to store the reversed words
        StringBuilder result = new StringBuilder();

        // Reverse each word and append it to the result
        for (String word : words) {
            char[] wordArray = word.toCharArray();
            int left = 0, right = wordArray.length - 1;
            while (left < right) {
                char temp = wordArray[left];
                wordArray[left] = wordArray[right];
                wordArray[right] = temp;
                left++;
                right--;
            }
            if (result.length() > 0) {
                result.append(" "); // Add a space between words
            }
            result.append(wordArray);
        }

        return result.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        // Example input sentence
        String input = "Hello World";

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Call the reverseWords method to reverse the words
        String reversed = solution.reverseWords(input);

        // Print the result
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
    }
}

