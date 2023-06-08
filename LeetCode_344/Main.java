package LeetCode_344;

class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(s1);
        System.out.println(s1);  // Output: "olleh"

        // Test case 2
        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        solution.reverseString(s2);
        System.out.println(s2);  // Output: "hannaH"
    }
}

