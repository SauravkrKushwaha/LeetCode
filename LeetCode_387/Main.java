package LeetCode_387;
import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();

        for (char a : s.toCharArray()) {
            mp.put(a, mp.getOrDefault(a, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (mp.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String input1 = "leetcode";
        System.out.println("First unique character in '" + input1 + "': " + solution.firstUniqChar(input1));

        String input2 = "loveleetcode";
        System.out.println("First unique character in '" + input2 + "': " + solution.firstUniqChar(input2));

        String input3 = "abcabc";
        System.out.println("First unique character in '" + input3 + "': " + solution.firstUniqChar(input3));
    }
}

