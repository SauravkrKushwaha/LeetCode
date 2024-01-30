import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            if ("*".equals(token) || "+".equals(token) || "/".equals(token) || "-".equals(token)) {
                int num1 = st.pop();
                int num2 = st.pop();
                st.push(calculate(num1, num2, token));
            } else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }

    private int calculate(int num1, int num2, String token) {
        int ans = 0;
        if ("*".equals(token)) {
            ans = num2 * num1;
        }
        if ("/".equals(token)) {
            ans = num2 / num1;
        }
        if ("+".equals(token)) {
            ans = num2 + num1;
        }
        if ("-".equals(token)) {
            ans = num2 - num1;
        }
        return ans;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] tokens1 = {"2", "1", "+", "3", "*"};
        int result1 = solution.evalRPN(tokens1);
        System.out.println("Test 1 result: " + result1);

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        int result2 = solution.evalRPN(tokens2);
        System.out.println("Test 2 result: " + result2);
    }
}

