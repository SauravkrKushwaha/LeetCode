package LeetCode_1337;
import java.util.Arrays;
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int[] weakest = new int[k];

        // Create an array to store the strength of each row
        int[] strength = new int[m];
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    count++;
                } else {
                    break; // As 0's appear after 1's, we can break the inner loop
                }
            }
            strength[i] = count;
        }

        // Create an array of row indices from 0 to m-1
        Integer[] indices = new Integer[m];
        for (int i = 0; i < m; i++) {
            indices[i] = i;
        }

        // Sort the indices array based on the strength array
        Arrays.sort(indices, (a, b) -> {
            if (strength[a] != strength[b]) {
                return Integer.compare(strength[a], strength[b]);
            } else {
                return Integer.compare(a, b);
            }
        });

        // Copy the first k elements from sorted indices to the weakest array
        for (int i = 0; i < k; i++) {
            weakest[i] = indices[i];
        }

        return weakest;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Sample binary matrix
        int[][] mat = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        int k = 3; // Specify the value of k
        int[] weakestRows = solution.kWeakestRows(mat, k);

        System.out.println("Indices of the " + k + " weakest rows:");
        for (int index : weakestRows) {
            System.out.println(index);
        }
    }
}

