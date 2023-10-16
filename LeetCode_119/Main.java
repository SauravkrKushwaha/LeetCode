package LeetCode_119;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> newRow = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    newRow.add(1);
                } else {
                    newRow.add(row.get(j - 1) + row.get(j));
                }
            }

            row = newRow;
        }

        return row;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int rowIndex1 = 3;
        List<Integer> result1 = solution.getRow(rowIndex1);
        System.out.println("Row " + rowIndex1 + " of Pascal's triangle: " + result1);

        int rowIndex2 = 0;
        List<Integer> result2 = solution.getRow(rowIndex2);
        System.out.println("Row " + rowIndex2 + " of Pascal's triangle: " + result2);

        int rowIndex3 = 1;
        List<Integer> result3 = solution.getRow(rowIndex3);
        System.out.println("Row " + rowIndex3 + " of Pascal's triangle: " + result3);
    }
}

