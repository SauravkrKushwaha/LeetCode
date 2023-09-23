package LeetCode_1048;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestStrChain(String[] words) {
        // Sort the words by length to process shorter words first
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        // Create a map to store the length of the longest word chain ending with each word
        Map<String, Integer> wordChainLengths = new HashMap<>();

        int maxLength = 1; // Initialize the maximum length to 1

        for (String word : words) {
            int currentLength = 1; // Initialize the length of the current word chain

            // Generate all possible predecessor words by removing one character
            for (int i = 0; i < word.length(); i++) {
                StringBuilder predecessor = new StringBuilder(word);
                predecessor.deleteCharAt(i);
                String predecessorWord = predecessor.toString();

                // Check if the predecessor word exists in the map
                if (wordChainLengths.containsKey(predecessorWord)) {
                    currentLength = Math.max(currentLength, wordChainLengths.get(predecessorWord) + 1);
                }
            }

            // Update the length of the current word chain in the map
            wordChainLengths.put(word, currentLength);

            // Update the maximum length
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage
        String[] words = {"a", "ab", "abc", "abcd", "abcde"};
        int maxLength = solution.longestStrChain(words);
        System.out.println("Maximum Length of Word Chain: " + maxLength);
    }
}

