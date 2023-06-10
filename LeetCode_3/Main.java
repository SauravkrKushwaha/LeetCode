package LeetCode_3;
import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        for(int right = 0;right < s.length();right++){
            char ch = s.charAt(right);
            if (!map.containsKey(ch)){
                map.put(ch,right);
            }
            else{
                left=Math.max(left,map.get(ch)+1);
                map.put(ch,right);
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}
// TC : O(n) , SC : O(n)
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "abcabcbb";
        int length1 = solution.lengthOfLongestSubstring(s1);
        System.out.println("Length of the longest substring without repeating characters in '" + s1 + "': " + length1);

        String s2 = "bbbbb";
        int length2 = solution.lengthOfLongestSubstring(s2);
        System.out.println("Length of the longest substring without repeating characters in '" + s2 + "': " + length2);

        String s3 = "pwwkew";
        int length3 = solution.lengthOfLongestSubstring(s3);
        System.out.println("Length of the longest substring without repeating characters in '" + s3 + "': " + length3);
    }
}

