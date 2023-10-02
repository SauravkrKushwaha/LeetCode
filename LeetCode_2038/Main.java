package LeetCode_2038;
class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        int aliceWins = 0;
        int bobWins = 0;

        // Count consecutive 'A's and 'B's
        for (int i = 0; i < n - 2; i++) {
            if (colors.charAt(i) == 'A' && colors.charAt(i + 1) == 'A' && colors.charAt(i + 2) == 'A') {
                aliceWins++;
            }
            if (colors.charAt(i) == 'B' && colors.charAt(i + 1) == 'B' && colors.charAt(i + 2) == 'B') {
                bobWins++;
            }
        }

        // Compare the number of wins
        return aliceWins > bobWins;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String colors1 = "AAABAAA";
        String colors2 = "BBAABBB";
        String colors3 = "AAABBB";

        boolean result1 = solution.winnerOfGame(colors1);
        boolean result2 = solution.winnerOfGame(colors2);
        boolean result3 = solution.winnerOfGame(colors3);

        System.out.println("Alice wins in colors1: " + result1); // Alice wins
        System.out.println("Alice wins in colors2: " + result2); // Alice wins
        System.out.println("Bob wins in colors3: " + result3);   // Bob wins
    }
}

