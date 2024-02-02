package LeetCode_1291;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> sequentialDigits(int low, int high) {
        for (int i = 1; i < 10; i++) {
            solve(low, high, i, 0);
        }
        Collections.sort(result);
        return result;
    }

    private void solve(int low, int high, int i, int ans) {
        if (ans >= low && ans <= high) {
            result.add(ans);
        }
        if (ans > high || i > 9) {
            return;
        }
        solve(low, high, i + 1, ans * 10 + i);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> result = solution.sequentialDigits(100, 300);
        System.out.println(result);
    }
}

