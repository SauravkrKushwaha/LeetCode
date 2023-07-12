package LeetCode_242;
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26];
        int remainingChars = s.length();

        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            int index = c - 'a';
            if (charCount[index] <= 0) {
                return false;
            }
            charCount[index]--;
            remainingChars--;
        }

        return remainingChars == 0;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "anagram";
        String t1 = "nagaram";
        boolean result1 = solution.isAnagram(s1, t1);
        System.out.println("Is '" + s1 + "' an anagram of '" + t1 + "'? " + result1);

        String s2 = "rat";
        String t2 = "car";
        boolean result2 = solution.isAnagram(s2, t2);
        System.out.println("Is '" + s2 + "' an anagram of '" + t2 + "'? " + result2);
    }
}

