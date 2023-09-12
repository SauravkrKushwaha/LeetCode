package LeetCode_1647;
import java.util.*;

class Solution {
    public int minDeletions(String s) {
        // Step 1: Count the frequency of each character
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create a set to keep track of seen frequencies
        Set<Integer> seenFrequencies = new HashSet<>();

        // Step 3: Initialize deletion count
        int deletionCount = 0;

        // Step 4: Iterate through frequencies and adjust as needed
        for (int frequency : charFrequency.values()) {
            while (seenFrequencies.contains(frequency)) {
                frequency--;
                deletionCount++;
            }
            // Step 5: Add the frequency to the set
            if (frequency > 0) {
                seenFrequencies.add(frequency);
            }
        }
        // Step 6: Return the deletion count
        return deletionCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aaabbccb";
        int deletions = solution.minDeletions(s);
        System.out.println("Minimum deletions: " + deletions); // Output: 0
    }
}
