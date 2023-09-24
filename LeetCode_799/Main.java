package LeetCode_799;

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] glasses = new double[101][101]; // Create a 2D array for the glasses (101x101 to handle edge cases)

        glasses[0][0] = (double) poured; // Pour the initial amount of champagne into the top glass

        // Iterate through each row
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double overflow = (glasses[i][j] - 1.0) / 2.0; // Calculate the overflow
                if (overflow > 0) {
                    glasses[i + 1][j] += overflow; // Distribute the overflow to the glasses in the row below
                    glasses[i + 1][j + 1] += overflow;
                }
            }
        }

        // Ensure the value is within the valid range
        return Math.min(1.0, glasses[query_row][query_glass]);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int poured1 = 1, query_row1 = 1, query_glass1 = 1;
        System.out.println("Output 1: " + solution.champagneTower(poured1, query_row1, query_glass1)); // Expected output: 0.0

        int poured2 = 2, query_row2 = 1, query_glass2 = 1;
        System.out.println("Output 2: " + solution.champagneTower(poured2, query_row2, query_glass2)); // Expected output: 0.5

        int poured3 = 100000009, query_row3 = 33, query_glass3 = 17;
        System.out.println("Output 3: " + solution.champagneTower(poured3, query_row3, query_glass3)); // Expected output: 1.0
    }
}

